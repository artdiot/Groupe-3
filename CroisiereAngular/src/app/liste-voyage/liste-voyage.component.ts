import { Component } from '@angular/core';
import { Voyage } from '../model';
import { AuthService } from '../service/auth.service';
import { VoyageService } from '../service/voyage.service';

@Component({
  selector: 'liste-voyage',
  templateUrl: './liste-voyage.component.html',
  styleUrls: ['./liste-voyage.component.scss']
})
export class ListeVoyageComponent {
  
  voyage : Voyage = null;
  formVoyage : Voyage;
  
 

  constructor(private voyageService : VoyageService, private authService : AuthService) {
    voyageService.findById(1).subscribe(resp=>{
      this.voyage=resp;
      console.log("prix " + resp.prix );
      });
    }
  
  listeVoyage():Array<Voyage>{
    return this.voyageService.findAll();
  }
  etapes(){
    
    return this.voyage.etapes;
  }

  connected(){
    return this.authService.connected;
  }
}
