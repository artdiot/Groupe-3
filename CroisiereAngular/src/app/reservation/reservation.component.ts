import { Component } from '@angular/core';
import { Client, Passager, Reservation, Voyage } from '../model';
import { AuthService } from '../service/auth.service';
import { ReservationService } from '../service/reservation.service';
import { voyageService } from '../service/voyage.service';


@Component({
  selector: 'app-ordinateur',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent {
  
  formReservation: Reservation = new Reservation();
  voyage : Voyage = null;
  formPassager: Passager = new Passager();

  constructor(private reservationService: ReservationService, private voyageService : voyageService, private authService: AuthService) {
    voyageService.findById(1).subscribe(resp=>{
      this.voyage=resp;
      });
  }

  list(): Array<Reservation> {
    return this.reservationService.findAll();
  }

  etapes(){
    return this.voyage.etapes;
  }
  add(): void {
    this.formReservation = new Reservation();
  }

  edit(id: number): void {
    this.reservationService.findById(id).subscribe(response => {
      this.formReservation = response;
    });
  }

  save(): void {
    if(this.formReservation.id) { // UPDATE
      this.reservationService.update(this.formReservation);
    } else { // CREATE
      this.formReservation.voyage=this.voyage;
      this.formReservation.passagers = [this.formPassager];
      this.formReservation.client = this.authService.connected.compte as Client; 
      this.reservationService.create(this.formReservation);
    }
    this.cancel();
  }

  remove(id: number): void {
    this.reservationService.remove(id);
  }

  cancel(): void {
    this.formReservation = null;
  }
}
