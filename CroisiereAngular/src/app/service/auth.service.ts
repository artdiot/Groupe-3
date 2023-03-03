import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Client, Utilisateur } from '../model';

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
          this.router.navigate(['/accueilclient/',{id: this.connected.compte.id}]);
        }
        if(this.connected.role=="ADMIN"){
          this.router.navigate(['/accueiladmin',{id: this.connected.compte.id}]);
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

  isClient(): boolean{
    if(this.connected){
      return(this.connected.role=="CLIENT");
    }
    else{
      return false;
    }
  }
  isAdmin(): boolean{
    if(this.connected){
      return(this.connected.role=="ADMIN");
    }
    else{
      return false;
    }
  }

}
