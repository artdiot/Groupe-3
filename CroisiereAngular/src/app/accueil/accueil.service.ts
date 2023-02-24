import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Passager } from '../model';

@Injectable({
  providedIn: 'root'
})
export class AccueilService {

  passagers: Array<Passager> = new Array<Passager>();
  constructor(private http: HttpClient) { 
    this.load();
  }

  findAll(): Array<Passager> {
    return this.passagers;
}

private load(): void {
  this.http.get<Array<Passager>>("http://localhost:8888/passager").subscribe(resp => {
    this.passagers = resp;
  });
}

}
