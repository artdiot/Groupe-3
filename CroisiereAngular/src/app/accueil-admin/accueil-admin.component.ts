import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

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
  

  constructor(private planeteService: PlaneteService, private etapeService: EtapeService, private voyageService: VoyageService){

  }



 

}
