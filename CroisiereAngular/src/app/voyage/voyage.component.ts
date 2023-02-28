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
  planeteD : Planete;
  etapes : Array<Etape>=new Array<Etape>();
  etapeSave : Etape = new Etape();
  

  constructor(private route: ActivatedRoute, private planeteService: PlaneteService, private etapeService: EtapeService, private voyageService: VoyageService){
    this.route.params.subscribe(params => {
      this.id=params["id"];
      console.log("id connexion " + this.id);
      });
  }

  addEtape(){

    this.etapes.push(this.formEtape);
    this.etapeService.create(this.formEtape);
    this.formEtape=null;
  }

  yes(){

    this.formEtape=new Etape();
    this.formEtape.depart = this.etapeService.etapeResp.arrivee;
    this.formEtape.planeteDepart = this.etapeService.etapeResp.planeteArrivee;
    
  }

  no(){}

  save(){

    this.formVoyage.etapes= this.etapes;
    //this.voyageService.create(this.formVoyage);
    

  }

  listPlanete():Array<Planete>{
    return this.planeteService.findAll();
  }

 
}
