import { Component } from '@angular/core';
import { Reservation } from '../model';
import { reservationService } from '../service/reservation.service';


@Component({
  selector: 'app-ordinateur',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class OrdinateurComponent {
  formReservation: Reservation = null;

  constructor(private reservationService: reservationService) {
  }

  list(): Array<Reservation> {
    return this.reservationService.findAll();
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
