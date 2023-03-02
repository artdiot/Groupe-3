import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Client, Planete, Reservation } from '../model';
import { AuthService } from '../service/auth.service';
import { EtapeService } from '../service/Etape.service';
import { ReservationService } from '../service/reservation.service';
import { VoyageService } from '../service/voyage.service';

@Component({
  selector: 'app-liste-reservation',
  templateUrl: './liste-reservation.component.html',
  styleUrls: ['./liste-reservation.component.scss']
})

export class ListeReservationComponent {

  client: Client= new Client();
  etapeService : EtapeService;
  reservationsClient : Array<Reservation> = new Array<Reservation>;

  constructor(private reservationService: ReservationService, private authService: AuthService, 
    etapeService : EtapeService, private voyageService: VoyageService, private http: HttpClient){
    this.client=this.authService.connected.compte as Client;
    this.load(this.client.id);
  }

  listUpcoming(): Array<Reservation> {
    let date = new Date(2023,2,28);
    return this.reservationsClient.filter(res => {
        let dateRes: Date = new Date(res.date);
         return dateRes >= date;
      });
  }

  listPast(): Array<Reservation> {
    let date = new Date(2023,2,28);
    return this.reservationsClient.filter(res => {
      console.log(res);
      let dateRes: Date = new Date(res.date);

      if(dateRes<date) {


        return true;
      }
      return false;
    });
  }

  edit(id: number): void{

  }

  remove(id: number): void{
    this.reservationService.remove(id);
  }

  planeteDepart(id: number):Planete{
    this.voyageService.findPlaneteDepart(id);
    return this.voyageService.planeteDepart;
  }

  planeteArrivee(id: number):Planete{
    this.voyageService.findPlaneteArrivee(id);
    return this.voyageService.planeteArrivee;
  }

  load(id : number){
    this.http.get<Array<Reservation>>("http://localhost:8888/client/" + id + "/reservations/").subscribe(resp => {
      this.reservationsClient = resp;
    }
  );
  }
}
