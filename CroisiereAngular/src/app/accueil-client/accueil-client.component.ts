import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Reservation } from '../model';
import { ReservationService } from '../service/reservation.service';
import { Client } from '../model';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-accueil-client',
  templateUrl: './accueil-client.component.html',
  styleUrls: ['./accueil-client.component.scss']
})
export class AccueilClientComponent {

  formReservation: Reservation = null;
  id:number;
  client:Client=new Client();

  constructor(private reservationService: ReservationService,private clientService: ClientService, private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.id=params["id"];
      clientService.findById(this.id).subscribe(client => {this.client = client;})
      });
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


