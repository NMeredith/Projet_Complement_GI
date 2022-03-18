import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './accueil/accueil.component';
import { ArchivageComponent } from './archivage/archivage.component';
import { DetailsDocComponent } from './details-doc/details-doc.component';
import { ListDocComponent } from './list-doc/list-doc.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { StatistiquesComponent } from './statistiques/statistiques.component';

const routes: Routes = [
  {path:'accueil', component: AccueilComponent},
  {path:'archivage', component: ArchivageComponent},
  {path:'list-doc', component: ListDocComponent},
  {path:'statistiques', component: StatistiquesComponent},
  {path:'document/:id', component: DetailsDocComponent},
  {path: '**', pathMatch: 'full', component: NotFoundComponent }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
