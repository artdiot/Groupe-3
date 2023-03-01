import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Reservation, Voyage } from '../model';
import { ReservationService } from '../service/reservation.service';
import { Client } from '../model';
import { ClientService } from '../service/client.service';
import { AuthService } from '../service/auth.service';
import { VoyageService } from '../service/voyage.service';

@Component({
  selector: 'app-accueil-client',
  templateUrl: './accueil-client.component.html',
  styleUrls: ['./accueil-client.component.scss']
})
export class AccueilClientComponent {

  
  formReservation: Reservation = null;
  client:Client=new Client();

  constructor(private reservationService: ReservationService,private clientService: ClientService, 
    private authService: AuthService, private voyageService: VoyageService) {
    this.client=this.authService.connected.compte as Client;
  }

  listReservation(): Array<Reservation> {
    return this.reservationService.findAll();
  }

  addReservation(): void {
    this.formReservation = new Reservation();
  }

  editReservation(id: number): void {
    this.reservationService.findById(id).subscribe(response => {
      this.formReservation = response;
    });
  }

  saveReservation(): void {
    if(this.formReservation.id) { // UPDATE
      this.reservationService.update(this.formReservation);
    } else { // CREATE
      this.reservationService.create(this.formReservation);
    }

    this.cancel();
  }

  removeReservation(id: number): void {
    this.reservationService.remove(id);
  }

  cancel(): void {
    this.formReservation = null;
  }


}


