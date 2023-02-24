import { HttpClient } from '@angular/common/http';client
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class reservationService {
  
  reservations: Array<Reservation> = new Array<Reservation>();

  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Reservation> {
    return this.reservations;
  }

 
  findById(id: number): Observable<Reservation> {
    return this.http.get<Reservation>("http://localhost:8888/client/" + id);
  }

  create(reservation: Reservation): void {
    this.http.post<Reservation>("http://localhost:8888/client", reservation).subscribe(resp => {
      this.load();
    });
  }

  update(reservation: Reservation): void {
    this.http.put<Reservation>("http://localhost:8888/client/" + reservation.id, reservation).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<void>("http://localhost:8888/client" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Reservation>>("http://localhost:8888/client").subscribe(resp => {
      this.reservations = resp;
    });
  }
}

