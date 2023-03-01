import { Component, Input } from '@angular/core';
import { Etape, Voyage } from '../model';
import { VoyageService } from '../service/voyage.service';

@Component({
  selector: 'info-voyage',
  templateUrl: './info-voyage.component.html',
  styleUrls: ['./info-voyage.component.scss']
})
export class InfoVoyageComponent {
  
  @Input('idVoyage') id:number;
  voyage:Voyage=null;

  constructor(private voyageService: VoyageService){
    console.log(this.id);
    this.voyageService.findById(this.id).subscribe(resp => {this.voyage=resp;});
  }

  voyages(): Array<Voyage>{
    return this.voyageService.findAll();
  }

  etapes(id:number):Array<Etape>{
    return this.voyages()[id].etapes;
  }

}
