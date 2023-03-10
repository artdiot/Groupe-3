import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';
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
  validate: boolean;
  
  
  
    constructor(private clientService: ClientService, private utilisateurService: UtilisateurService, private router :Router) {
      this.formClient.adresse=new Adresse();
      this.validate=false;

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
  
/*     save(): void {
      if(this.formClient.id) { // UPDATE
        this.clientService.update(this.formClient);
      } else { // CREATE
       
        this.clientService.create(this.formClient, this.formUtil.identifiant, this.formUtil.motDePasse);
        this.router.navigate(['/']);
       
               
      }
      this.cancel();
    } */

    save(): void {
      if(this.formClient.id) { // UPDATE
        this.clientService.update(this.formClient);
      } else { // CREATE
       
        this.clientService.create(this.formClient, this.formUtil.identifiant, this.formUtil.motDePasse);
        this.router.navigate(['/']);
       
               
      }
      this.cancel();
    }
    
    suivant(){
      console.log(this.formClient.nom);
      this.clientService.findByNom(this.formClient.nom).subscribe(resp=>{
        
        this.formUtil.nom=resp.nom;
        this.formUtil.prenom=resp.prenom;
        this.formUtil.role="CLIENT";
        this.formUtil.compte= resp
        
        });
      
    }
    saveUtilisateur(){
      if(this.formUtil.id) { // UPDATE
        this.utilisateurService.update(this.formUtil);
      } else { // CREATE
        this.utilisateurService.create(this.formUtil);

        
                
      }
      this.cancel();
    }


    remove(id: number): void {
      this.clientService.remove(id);

    }
  
    cancel(): void {
      
      this.formClient = null;
      this.formUtil=new Utilisateur();
    }
  }

