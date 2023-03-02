import { Component } from '@angular/core';
import { Voyage } from '../model';
import { VoyageService } from '../service/voyage.service';

@Component({
  selector: 'app-liste-voyage',
  templateUrl: './liste-voyage.component.html',
  styleUrls: ['./liste-voyage.component.scss']
})
export class ListeVoyageComponent {
  
  voyage:VoyageService;
  constructor(){

  }
  
  listeVoyage():Array<Voyage>{
    return this.voyage.findAll();
  }
}
