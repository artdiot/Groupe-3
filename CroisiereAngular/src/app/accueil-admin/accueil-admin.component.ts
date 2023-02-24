import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-accueil-admin',
  templateUrl: './accueil-admin.component.html',
  styleUrls: ['./accueil-admin.component.scss']
})
export class AccueilAdminComponent {

  id:number;

  constructor(private route: ActivatedRoute){
    this.route.queryParams.subscribe(params => {
      this.id=params["id"];
      console.log(this.id);
      });
  }
}
