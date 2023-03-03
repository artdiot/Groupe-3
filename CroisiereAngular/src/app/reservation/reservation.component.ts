import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client, Passager, Reservation, Voyage } from '../model';
import { AuthService } from '../service/auth.service';
import { PassagerService } from '../service/passager.service';
import { ReservationService } from '../service/reservation.service';
import { VoyageService} from '../service/voyage.service';
import {FormBuilder, FormArray, FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent {

  
  formReservation: Reservation = new Reservation();
  voyage : Voyage = null;
  formVoyage : Voyage;
  formPassager: Passager = new Passager();
  passagers : Array<Passager> = new Array<Passager>();
  showConfirm: boolean = false;
  id : number;

  constructor(private reservationService: ReservationService, private voyageService : VoyageService, private authService: AuthService, private router : Router, 
    private passagerService: PassagerService, private route : ActivatedRoute) {
    this.route.params.subscribe(params => {
      this.id = params["id"];
      voyageService.findById(this.id).subscribe(resp=>{
        this.voyage=resp;
        });
    })

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
      this.formReservation.passagers=this.passagers;
      this.formReservation.client = this.authService.connected.compte as Client; 
      this.reservationService.createForm(this.formReservation);
      this.router.navigate(['/accueilclient',{id:this.authService.connected.compte.id}]);
    }
    this.cancel();
  }

  remove(id: number): void {
    this.reservationService.remove(id);
  }

  cancel(): void {
    this.formReservation = null;
    this.showConfirm=false;
    this.formPassager=new Passager();
  }

  addPassager():void{
    this.passagerService.create(this.formPassager);
    this.formPassager=null;
  }

  yes(){
    
    this.formPassager=new Passager();
    this.passagers.push(this.passagerService.passagerResp);
  }

  no(){
    this.passagers.push(this.passagerService.passagerResp);
    this.formPassager=null;
    this.showConfirm=true;
  }
}
