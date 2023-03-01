import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Etape, Planete, Voyage } from '../model';
import { EtapeService } from '../service/Etape.service';
import { PlaneteService } from '../service/planete.service';
import { VoyageService } from '../service/voyage.service';

@Component({
  selector: 'app-voyage',
  templateUrl: './voyage.component.html',
  styleUrls: ['./voyage.component.scss']
})
export class VoyageComponent {

  id:number;
  formVoyage: Voyage = null;
  formEtape: Etape = new Etape();

  etapes : Array<Etape>=new Array<Etape>();
  etapeSave : Etape = new Etape();

  dateDepart : string;
  dateArrivee : string;
  planeteDepart : Planete;
  planeteArrivee : Planete;
  
  listeVide : Boolean = true;
  

  constructor(private route: ActivatedRoute, private planeteService: PlaneteService, private etapeService: EtapeService, private voyageService: VoyageService){
    this.route.params.subscribe(params => {
      this.id=params["id"];
      console.log("id connexion " + this.id);
      
      });
  }

  addEtape(){

    this.etapeService.create(this.formEtape);
    this.listeVide=false;
    this.formEtape=null;
    
    
  }

  yes(){
    
  this.etapes.push(this.etapeService.etapeResp);
  
  this.formEtape=new Etape();
  this.formEtape.depart = this.etapeService.etapeResp.arrivee;
  this.formEtape.planeteDepart = this.etapeService.etapeResp.planeteArrivee;
  this.planeteDepart=this.etapeService.etapeResp.planeteArrivee;
    
  }

  no(){

    this.etapes.push(this.etapeService.etapeResp);

    this.formVoyage=new Voyage();
    this.findInfo();
  }

  save(){

    
    this.formVoyage.etapes= this.etapes;
    this.voyageService.create(this.formVoyage);    

  }

  listPlanete():Array<Planete>{
    return this.planeteService.findAll();
  }

  findInfo(): void{
    
    console.log(this.etapes[0].depart);
    this.dateDepart = this.etapes[0].depart;
    this.planeteDepart = this.etapes[0].planeteDepart;
    
    let idsize = this.etapes.length -1;

    this.dateArrivee = this.etapes[idsize].arrivee;
    this.planeteArrivee=this.etapes[idsize].planeteArrivee
  }
}
