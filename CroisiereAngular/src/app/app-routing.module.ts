import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilAdminComponent } from './accueil-admin/accueil-admin.component';
import { AccueilClientComponent } from './accueil-client/accueil-client.component';
import { AccueilComponent } from './accueil/accueil.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { ListeReservationComponent } from './liste-reservation/liste-reservation.component';
import { ReservationComponent } from './reservation/reservation.component';
import { VoyageComponent } from './voyage/voyage.component';

const routes: Routes = [
  {path: "", component: AccueilComponent, pathMatch: 'full'},
  {path: "accueilclient", component: AccueilClientComponent},
  {path: "accueiladmin", component: AccueilAdminComponent},
  {path: "connexion", component: ConnexionComponent},
  {path: "reservation", component: ReservationComponent},
  {path: "inscription", component: InscriptionComponent},
  {path:"listeReservation", component:ListeReservationComponent},
  {path: "voyage", component:VoyageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
