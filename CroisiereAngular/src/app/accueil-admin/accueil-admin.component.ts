import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Etape, Planete, Voyage } from '../model';
import { EtapeService } from '../service/Etape.service';
import { PlaneteService } from '../service/planete.service';

@Component({
  selector: 'app-accueil-admin',
  templateUrl: './accueil-admin.component.html',
  styleUrls: ['./accueil-admin.component.scss']
})
export class AccueilAdminComponent {

  id:number;
  planete: Planete;
  formVoyage: Voyage = new Voyage();
  planeteD:Planete;
  etape:Etape;
  

  constructor(private route: ActivatedRoute, private planeteService: PlaneteService, private etapeService: EtapeService){
    this.route.params.subscribe(params => {
      this.id=params["id"];
      console.log(this.id);
      });
  }

  save(){}

  listPlanete():Array<Planete>{
    return this.planeteService.findAll();
  }

  listEtape():Array<Etape>{
    return this.etapeService.findAll();
  }

}
