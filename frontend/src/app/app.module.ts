import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AccueilComponent } from './accueil/accueil.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ListDocComponent } from './list-doc/list-doc.component';
import { ArchivageComponent } from './archivage/archivage.component';
import { StatistiquesComponent } from './statistiques/statistiques.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NotFoundComponent } from './not-found/not-found.component';
import { DetailsDocComponent } from './details-doc/details-doc.component';

@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent,
    ListDocComponent,
    ArchivageComponent,
    StatistiquesComponent,
    NotFoundComponent,
    DetailsDocComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FontAwesomeModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
