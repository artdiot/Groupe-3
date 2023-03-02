import { Component } from '@angular/core';
import { Voyage } from '../model';
import { VoyageService } from '../service/voyage.service';

@Component({
  selector: 'app-liste-voyage',
  templateUrl: './liste-voyage.component.html',
  styleUrls: ['./liste-voyage.component.scss']
})

export class ListeVoyageComponent {
  
  voyage : Voyage = null;
  formVoyage : Voyage;

 

  constructor(private voyageService : VoyageService   ) {
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
}
