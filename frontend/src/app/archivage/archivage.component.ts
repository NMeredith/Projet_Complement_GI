import { Component, OnInit } from '@angular/core';
import { mergeMap } from 'rxjs';
import { DocumentService } from '../services/documents.service';

@Component({
  selector: 'app-archivage',
  templateUrl: './archivage.component.html',
  styleUrls: ['./archivage.component.scss'],
})
export class ArchivageComponent implements OnInit {
  doc: any = {};
  submitted = false;

  documents: any[]= [];

  constructor(private documentService: DocumentService) {}

  ngOnInit(): void {}

  add() {
    console.log(this.doc)
    const tempDoc= this.doc;
    tempDoc.type = {
      "nom": tempDoc.type
    };
    tempDoc.date= (new Date()).toISOString();
    this.documentService
      .create(tempDoc)
      .subscribe(personnel => {
        this.documents = personnel;
        this.submitted=true;
      });
  }

  newDocument(): void {
    this.submitted = false;
    this.doc.nom = '';
  }
}
