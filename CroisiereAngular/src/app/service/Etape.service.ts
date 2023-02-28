import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Etape } from '../model';

@Injectable({
  providedIn: 'root'
})
export class EtapeService {
  
  etapes: Array<Etape> = new Array<Etape>();
  etapeResp= new Etape();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Etape> {
    return this.etapes;
  }

 

  findById(id: number): Observable<Etape> {
    return this.http.get<Etape>("http://localhost:8888/etape/" + id);
  }

  findByVoyage(id:number): Array<Etape>{
    return this.findAll().filter(etape => { return etape.voyage.id == id});
  }

  create(etape: Etape): void {
    
    this.http.post<Etape>("http://localhost:8888/etape", etape).subscribe(resp => {
      
      this.etapeResp=resp;
     
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

