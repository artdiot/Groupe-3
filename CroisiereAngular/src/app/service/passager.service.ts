import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Passager } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PassagerService {

  passagers: Array<Passager> = new Array<Passager>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Passager> {
    return this.passagers;
  }

  findAllOrphans(id?: number): Observable<Array<Passager>> {
    return this.http.get<Array<Passager>>("http://localhost:8888/passager/orphans/"+(id?id:""));
  }

  findById(id: number): Observable<Passager> {
    return this.http.get<Passager>("http://localhost:8888/passager/" + id);
  }

  create(passager: Passager): void {
    this.http.post<Passager>("http://localhost:8888/passager", passager).subscribe(resp => {
      this.load();
    });
  }

  update(passager: Passager): void {
    this.http.put<Passager>("http://localhost:8888/passager/" + passager.id, passager).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/passager/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Passager>>("http://localhost:8888/passager").subscribe(resp => {
      this.passagers = resp;
    });
  }
}



