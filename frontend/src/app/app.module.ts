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

@NgModule({
  declarations: [
    AppComponent,
    AccueilComponent,
    ListDocComponent,
    ArchivageComponent,
    StatistiquesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FontAwesomeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
