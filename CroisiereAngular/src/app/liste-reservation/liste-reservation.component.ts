import { Component } from '@angular/core';
import { Client, Reservation } from '../model';
import { AuthService } from '../service/auth.service';
import { EtapeService } from '../service/Etape.service';
import { ReservationService } from '../service/reservation.service';

@Component({
  selector: 'app-liste-reservation',
  templateUrl: './liste-reservation.component.html',
  styleUrls: ['./liste-reservation.component.scss']
})

export class ListeReservationComponent {

  client: Client= new Client();
  etapeService : EtapeService;

  constructor(private reservationService: ReservationService, private authService: AuthService, etapeService : EtapeService){
    this.client=this.authService.connected.compte as Client;
  }

  listUpcoming(): Array<Reservation> {
    let date = new Date(2023,2,28);
    return this.reservationService.findAllByClient(this.client.id).filter(res => {
        let dateRes: Date = new Date(res.date);
         return dateRes >= date;
      });
  }

  listPast(): Array<Reservation> {
    let date = new Date(2023,2,28);
    return this.reservationService.findAllByClient(this.client.id).filter(res => {
      let dateRes: Date = new Date(res.date);
       return dateRes<date;
      });
  }

  edit(id: number): void{

  }

  remove(id: number): void{
    this.reservationService.remove(id);
  }

}
