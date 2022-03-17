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
  page: any = {};
  documents: any[] = [];
  pageIndex = 0;
  started: boolean | undefined = true;
  ended:boolean | undefined = true;

  constructor(private listDocumentService: DocumentService) {

  }
  ngOnInit(): void {
    this.listDocumentService.fetch(this.pageIndex).subscribe((files) => {
      if (files.content ) {
        console.log(files.first, files.last);
        this.started = files.first;
        this.ended = files.last;
        this.documents = files.content;
      }

    });
  }

  next(): void {
    if(this.ended){
      return;
    }
    this.pageIndex++;
    this.listDocumentService.fetch(this.pageIndex).subscribe((files) => {
      if (files.content) {
        this.started = files.first;
        this.ended = files.last;
        this.documents = files.content;
      }
    });
  }

  previous(): void{
    if(this.started){
      return;
    }
    this.pageIndex--;
    this.listDocumentService.fetch(this.pageIndex).subscribe((files) => {
      if (files.content) {
        this.started = files.first;
        this.ended = files.last;
        this.documents = files.content;
      }
    });
  }

  afficheFile(file:string): void{
    alert(file);
  }

  delete(id: number): void {
    this.listDocumentService.delete(id);
  }
}

