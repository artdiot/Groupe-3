import { Component } from '@angular/core';
import { Router } from '@angular/router';
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

  }

  connect(): void {
    this.authService.connection(this.login, this.password);
    }

  isConnected(): boolean {
    return (this.authService.checkUser()?true:false)
  }
}
