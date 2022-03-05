import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { ArchivageComponent } from './archivage/archivage.component';
import { ListDocComponent } from './list-doc/list-doc.component';
import { StatistiquesComponent } from './statistiques/statistiques.component';

const routes: Routes = [
  {path: '', redirectTo: 'accueil', pathMatch: 'full' },
  {path:'accueil', component: AccueilComponent},
  {path:'archivage', component: ArchivageComponent},
  {path:'list-doc', component: ListDocComponent},
  {path:'statistiques', component: StatistiquesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
