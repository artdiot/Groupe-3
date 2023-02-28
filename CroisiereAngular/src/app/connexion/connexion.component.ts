import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Admin, Client } from '../model';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent {
  login: string;
  password: string;

  constructor(private authService: AuthService, private router: Router) {
    if(authService.connected){
      if(authService.connected instanceof Client){
      router.navigate(['/accueilclient']);
      }
      if(authService.connected instanceof Admin){
        router.navigate(['/accueiladmin]']);
      }
    }
  }

  connect(): void {
    this.authService.connection(this.login, this.password);
    }

  isConnected(): boolean {
    return (this.authService.checkUser()?true:false)
  }
}
