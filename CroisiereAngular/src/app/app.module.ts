import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccueilComponent } from './accueil/accueil.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule }from '@angular/common/http';
import { AccueilClientComponent } from './accueil-client/accueil-client.component';
import { AccueilAdminComponent } from './accueil-admin/accueil-admin.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { ReservationComponent } from './reservation/reservation.component';
import { ListeReservationComponent } from './liste-reservation/liste-reservation.component';
import { VoyageComponent } from './voyage/voyage.component';
import { ListeVoyageComponent } from './liste-voyage/liste-voyage.component';

@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent,
    AccueilClientComponent,
    AccueilAdminComponent,
    InscriptionComponent,
    ConnexionComponent,
    NavBarComponent,
    ReservationComponent,
    ListeReservationComponent,
    VoyageComponent,
    ListeVoyageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
