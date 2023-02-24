import { Component } from '@angular/core';
import { Passager } from '../model';
import { PassagerService } from './passager.service';



@Component({
  selector: 'accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent {

  constructor(private servicePassager: PassagerService) {
  }

  list(): Array<Passager> {
    return this.servicePassager.findAll();
  }
}
