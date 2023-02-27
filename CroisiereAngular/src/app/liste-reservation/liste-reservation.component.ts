import { Component } from '@angular/core';
import { Reservation } from '../model';
import { ReservationService } from '../service/reservation.service';

@Component({
  selector: 'app-liste-reservation',
  templateUrl: './liste-reservation.component.html',
  styleUrls: ['./liste-reservation.component.scss']
})
export class ListeReservationComponent {
  constructor(private reservationService: ReservationService){

  }

  listUpcoming(): Array<Reservation> {
    return this.reservationService.findAll().filter(res => {
      let dateRes: Date = new Date(res.date);
      let date = new Date(2023,2,27);
      dateRes>=date});
  }

  listPast(): Array<Reservation> {
    return this.reservationService.findAll().filter(res => {
      let dateRes: Date = new Date(res.date);
      let date = new Date(2023,2,27);
      dateRes<date});
  }

  edit(id: number): void{}

  remove(id: number): void{}

}
