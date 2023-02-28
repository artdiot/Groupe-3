import { Component } from '@angular/core';
import { Passager, Reservation, Voyage } from '../model';
import { ReservationService } from '../service/reservation.service';
import { PassagerService } from '../service/passager.service';
import { VoyageService } from '../service/voyage.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent {
  formReservation: Reservation = new Reservation();
  formPassager:Passager = new Passager();
  formVoyage:Voyage = new Voyage();

  constructor(private reservationService: ReservationService,private passagerService: PassagerService,
    private voyageService: VoyageService, private router :Router) {
  }

  
  list(): Array<Reservation> {
    return this.reservationService.findAll();
  }

  add(): void {

    this.formVoyage = new Voyage(200,123);
    this.formReservation = new Reservation();
    this.formReservation.voyage=this.formVoyage;
    this.formReservation.passagers.push(this.formPassager);
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
