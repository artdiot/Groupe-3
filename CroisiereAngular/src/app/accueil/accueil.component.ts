import { Component } from '@angular/core';
import { Passager } from '../model';
import { AccueilService } from './accueil.service';

@Component({
  selector: 'accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent {

  constructor(private accueilService: AccueilService) {
  }

  list(): Array<Passager> {
    return this.accueilService.findAll();
  }
}
