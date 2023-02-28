import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Etape, Planete, Voyage } from '../model';
import { EtapeService } from '../service/Etape.service';
import { PlaneteService } from '../service/planete.service';
import { VoyageService } from '../service/voyage.service';

@Component({
  selector: 'app-accueil-admin',
  templateUrl: './accueil-admin.component.html',
  styleUrls: ['./accueil-admin.component.scss']
})
export class AccueilAdminComponent {

  id:number;
  
  

  constructor(private route: ActivatedRoute, private planeteService: PlaneteService, private etapeService: EtapeService, private voyageService: VoyageService){
    this.route.params.subscribe(params => {
      this.id=params["id"];
      console.log(this.id);
      });
  }



 

}
