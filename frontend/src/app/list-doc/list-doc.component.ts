import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../services/documents.service';
import { Document } from '../model/document';
import { Page } from '../model/page';

@Component({
  selector: 'app-list-doc',
  templateUrl: './list-doc.component.html',
  styleUrls: ['./list-doc.component.scss'],
})
export class ListDocComponent implements OnInit {
  page: any ={};
  documents: any [] = [];
  currentIndex: number =0;


  constructor(private listDocumentService: DocumentService) {
    //Rien à faire ici
  }

  ngOnInit(): void {
    this.listDocumentService.fetch(this.currentIndex).subscribe(files => {
      this.page = files ;
      if(this.page.content){
        this.documents = this.page.content;      }

    });
  }

}
