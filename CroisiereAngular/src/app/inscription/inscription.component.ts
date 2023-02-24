import { Component } from '@angular/core';
import { Client } from '../model';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent {

    formClient: Client = new Client();
  
    constructor(private clientService: ClientService) {
    }
  
    list(): Array<Client> {
      return this.clientService.findAll();
    }
  
    add(): void {
      this.formClient = new Client();
    }
  
    edit(id: number): void {
      this.clientService.findById(id).subscribe(response => {
        this.formClient = response;
      });
    }
  
    save(): void {
      if(this.formClient.id) { // UPDATE
        this.clientService.update(this.formClient);
      } else { // CREATE
        this.clientService.create(this.formClient);
      }
  
      this.cancel();
    }
  
    remove(id: number): void {
      this.clientService.remove(id);
    }
  
    cancel(): void {
      this.formClient = null;
    }
  }

