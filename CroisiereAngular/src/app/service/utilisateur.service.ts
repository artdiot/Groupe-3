import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Utilisateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  utilisateurs: Array<Utilisateur> = new Array<Utilisateur>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Utilisateur> {
    return this.utilisateurs;
  }



  findById(id: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>("http://localhost:8888/utilisateur/" + id);
  }

  create(utilisateur: Utilisateur): void {
    console.log("coucou2");
    this.http.post<Utilisateur>("http://localhost:8888/utilisateur", utilisateur).subscribe(resp => {
      this.load();
    });
  }

  update(utilisateur: Utilisateur): void {
    this.http.put<Utilisateur>("http://localhost:8888/utilisateur/" + utilisateur.id, utilisateur).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/utilisateur/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Utilisateur>>("http://localhost:8888/utilisateur").subscribe(resp => {
      this.utilisateurs = resp;
    });
  }
}
