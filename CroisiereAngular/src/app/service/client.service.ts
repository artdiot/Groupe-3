import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  clients: Array<Client> = new Array<Client>();

  constructor(private http: HttpClient) {
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


  create(client: Client): void {
    this.http.post<Client>("http://localhost:8888/client", client).subscribe(resp => {
      this.load();
      
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
