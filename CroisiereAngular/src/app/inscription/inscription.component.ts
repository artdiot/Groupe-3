import { Component } from '@angular/core';
import { Adresse, Client, Utilisateur } from '../model';
import { ClientService } from '../service/client.service';
import { UtilisateurService } from '../service/utilisateur.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent {

  formClient: Client = new Client();
  formUtil: Utilisateur = new Utilisateur();
  
  
    constructor(private clientService: ClientService, private utilisateurService: UtilisateurService) {
      this.formClient.adresse=new Adresse();
    }
  
    list(): Array<Client> {
      return this.clientService.findAll();
    }
  
    add(): void {
      this.formClient = new Client();
      this.formClient.adresse=new Adresse();
      this.formUtil=new Utilisateur();
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
        this.formUtil.nom=this.formClient.nom;
        this.formUtil.prenom=this.formClient.prenom;
        
      }
  
      this.cancel();
    }
  
    remove(id: number): void {
      this.clientService.remove(id);

    }
  
    cancel(): void {
      this.formClient.adresse=null;
      this.formClient = null;
      this.formUtil=new Utilisateur();
    }
  }

