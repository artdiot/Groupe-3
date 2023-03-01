import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Admin, Etape, Planete, Voyage } from '../model';
import { AuthService } from '../service/auth.service';
import { EtapeService } from '../service/Etape.service';
import { PlaneteService } from '../service/planete.service';
import { VoyageService } from '../service/voyage.service';

@Component({
  selector: 'app-accueil-admin',
  templateUrl: './accueil-admin.component.html',
  styleUrls: ['./accueil-admin.component.scss']
})
export class AccueilAdminComponent {

  admin: Admin = new Admin();



  constructor(private planeteService: PlaneteService, private etapeService: EtapeService, private voyageService: VoyageService,
    authService: AuthService) {
    this.admin = authService.connected.compte as Admin;
  };


}








