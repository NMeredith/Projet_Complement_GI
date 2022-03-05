import { Component } from '@angular/core';
import {faFolder, faCar, faSearch } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'frontend';
  iconLogo = faFolder;
  iconCar = faCar;
  iconSearch = faSearch
}
