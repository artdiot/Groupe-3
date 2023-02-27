import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Planete } from '../model';

@Injectable({
  providedIn: 'root'
})
export class PlaneteService {
  
  planetes: Array<Planete> = new Array<Planete>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Planete> {
    return this.planetes;
  }

  findAllOrphans(id?: number): Observable<Array<Planete>> {
    return this.http.get<Array<Planete>>("http://localhost:8888/planete/orphans/"+(id?id:""));
  }

  findById(id: number): Observable<Planete> {
    return this.http.get<Planete>("http://localhost:8888/planete/" + id);
  }

  create(planete: Planete): void {
    this.http.post<Planete>("http://localhost:8888/planete", planete).subscribe(resp => {
      this.load();
    });
  }

  update(planete: Planete): void {
    this.http.put<Planete>("http://localhost:8888/planete/" + planete.id, planete).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/planete/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Planete>>("http://localhost:8888/planete").subscribe(resp => {
      this.planetes = resp;
    });
  }
}

