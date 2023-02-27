import { Component } from '@angular/core';
import { Utilisateur } from '../model';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent {

 

  constructor(authService: AuthService){
    
 
     
  }

}
