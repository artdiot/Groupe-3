import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Utilisateur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  connected: Utilisateur = null;
  constructor(private http: HttpClient, private router: Router) {
  }

  connection(login: string, password: string) {
    this.http.post("http://localhost:8888/utilisateur/auth/", {
      login: login,
      password: password
    }).subscribe((resp: any) => {
      this.connected = resp;
      if (this.connected) {
        if (this.connected.role == "CLIENT") {
          this.router.navigate(['/accueilclient'])
        }
        if(this.connected.role=="ADMIN"){
          this.router.navigate(['/accueiladmin'])
        }
      }
    }
    )
  }

  disconnect() {
    this.connected = null;
  }

  checkUser(): Utilisateur {
    return this.connected;
  }
}
