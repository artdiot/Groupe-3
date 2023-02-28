import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Client, Passager, Reservation, Voyage } from '../model';
import { AuthService } from '../service/auth.service';
import { PassagerService } from '../service/passager.service';
import { ReservationService } from '../service/reservation.service';
import { VoyageService} from '../service/voyage.service';


=======
import { Passager, Reservation, Voyage } from '../model';
import { ReservationService } from '../service/reservation.service';
import { PassagerService } from '../service/passager.service';
import { VoyageService } from '../service/voyage.service';
import { Router } from '@angular/router';
>>>>>>> rafiq
@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent {
<<<<<<< HEAD
  
  formReservation: Reservation = new Reservation();
  voyage : Voyage = null;
  formPassager: Passager = new Passager();

  constructor(private reservationService: ReservationService, private voyageService : VoyageService, private authService: AuthService, private router : Router, private passagerService: PassagerService) {
    voyageService.findById(1).subscribe(resp=>{
      this.voyage=resp;
      console.log("prix " + resp.prix );
      });
=======
  formReservation: Reservation = new Reservation();
  formPassager:Passager = new Passager();
  formVoyage:Voyage = new Voyage();

  constructor(private reservationService: ReservationService,private passagerService: PassagerService,
    private voyageService: VoyageService, private router :Router) {
>>>>>>> rafiq
  }

  
  list(): Array<Reservation> {
    return this.reservationService.findAll();
  }

  etapes(){
    return this.voyage.etapes;
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
      this.formReservation.voyage=this.voyage;
      this.passagerService.create(this.formPassager);
      this.formPassager.reservation=this.formReservation;
      this.formReservation.client = this.authService.connected.compte as Client; 
      this.reservationService.create(this.formReservation);
      this.router.navigate(['/accueilclient',{id:this.authService.connected.compte.id}]);
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
