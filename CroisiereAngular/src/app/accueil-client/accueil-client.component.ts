import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Reservation } from '../model';
import { reservationService } from '../service/reservation.service';

@Component({
  selector: 'app-accueil-client',
  templateUrl: './accueil-client.component.html',
  styleUrls: ['./accueil-client.component.scss']
})
export class AccueilClientComponent {

  formReservation: Reservation = null;
  id:number;

  constructor(private reservationService: reservationService, private route: ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.id=params["id"];
      console.log(this.id);
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


