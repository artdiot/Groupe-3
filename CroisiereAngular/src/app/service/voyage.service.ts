import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Planete, Voyage } from '../model';

@Injectable({
  providedIn: 'root'
})
export class VoyageService {
  
  voyages: Array<Voyage> = new Array<Voyage>();
  dateDepart: Date = new Date();
  dateArrivee: Date = new Date();
  planeteDepart: Planete = new Planete();
  planeteArrivee: Planete = new Planete();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Voyage> {
    return this.voyages;
  }

  findById(id: number): Observable<Voyage> {
    return this.http.get<Voyage>("http://localhost:8888/voyage/" + id);
  }

  create(voyage: Voyage): void {
      this.http.post<Voyage>("http://localhost:8888/voyage", voyage).subscribe(resp => {
      this.load();
    });
  }

  update(voyage: Voyage): void {
    this.http.put<Voyage>("http://localhost:8888/voyage/" + voyage.id, voyage).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/voyage/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Voyage>>("http://localhost:8888/voyage").subscribe(resp => {
      this.voyages = resp;
    });
  }

  findDateDepart(id: number): void{
    this.http.get<Date>("http://localhost:8888/voyage/datedepart/"+ id).subscribe(resp => {
    this.dateDepart= resp;
    console.log(this.dateDepart);
  });
  }
  
  findDateArrivee(id: number): void{
    this.http.get<Date>("http://localhost:8888/voyage/datearrivee/"+ id).subscribe(resp => {
    this.dateArrivee= resp;
    console.log(this.dateArrivee);
    
  });
  }
   
  findPlaneteDepart(id:number): void{
    this.http.get<Planete>("http://localhost:8888/voyage/planetedepart/"+ id).subscribe(resp => {
      this.planeteDepart=resp;
  });
}

findPlaneteArrivee(id:number): void{
  this.http.get<Planete>("http://localhost:8888/voyage/planetearrivee/"+ id).subscribe(resp => {
    this.planeteArrivee= resp;
});
}

}