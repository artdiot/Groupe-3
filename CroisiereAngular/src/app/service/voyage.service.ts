import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Voyage } from '../model';

@Injectable({
  providedIn: 'root'
})
export class voyageService {
  
  voyages: Array<Voyage> = new Array<Voyage>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Voyage> {
    return this.voyages;
  }

  findAllOrphans(id?: number): Observable<Array<Voyage>> {
    return this.http.get<Array<Voyage>>("http://localhost:8888/voyage/orphans/"+(id?id:""));
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
}

