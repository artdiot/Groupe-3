import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Etape } from '../model';

@Injectable({
  providedIn: 'root'
})
export class EtapeService {
  
  etapes: Array<Etape> = new Array<Etape>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Etape> {
    return this.etapes;
  }

 

  findById(id: number): Observable<Etape> {
    return this.http.get<Etape>("http://localhost:8888/etape/" + id);
  }

  create(etape: Etape): void {
    this.http.post<Etape>("http://localhost:8888/Etape", etape).subscribe(resp => {
      this.load();
    });
  }

  update(etape: Etape): void {
    this.http.put<Etape>("http://localhost:8888/etape/" + etape.id, etape).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/etape/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Etape>>("http://localhost:8888/etape").subscribe(resp => {
      this.etapes = resp;
    });
  }
}

