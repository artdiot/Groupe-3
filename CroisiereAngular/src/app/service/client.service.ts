import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client, Utilisateur } from '../model';
import { UtilisateurService } from './utilisateur.service';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  utilisateur: Utilisateur = new Utilisateur();
  clients: Array<Client> = new Array<Client>();

  constructor(private http: HttpClient, private utilisateurService: UtilisateurService) {
    this.load();
  }

  findAll(): Array<Client> {
    return this.clients;
  }


  findById(id: number): Observable<Client> {
    return this.http.get<Client>("http://localhost:8888/client/" + id);
  }

  findByNom(nom:string): Observable<Client> {
    return this.http.get<Client>("http://localhost:8888/client/nom/" + nom);
  }


  create(client: Client, identifiant: string, motdepasse: string): void {
    this.http.post<Client>("http://localhost:8888/client", client).subscribe(resp => {

    console.log("ça marche");

    this.http.get<Client>("http://localhost:8888/client/nom/" + client.nom).subscribe(resp2=>{
      
    console.log("coucou");
      this.utilisateur.nom=resp2.nom;
      this.utilisateur.prenom=resp2.prenom;
      this.utilisateur.role="CLIENT";
      this.utilisateur.compte= resp2;
      this.utilisateur.identifiant=identifiant;
      this.utilisateur.motDePasse=motdepasse;
      this.utilisateurService.create(this.utilisateur);

    })
      
    });
  }

  update(client: Client): void {
    this.http.put<Client>("http://localhost:8888/client/" + client.id, client).subscribe(resp => {
      this.load();
      
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/client/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Client>>("http://localhost:8888/client").subscribe(resp => {
      this.clients = resp;
    });
  }
}
