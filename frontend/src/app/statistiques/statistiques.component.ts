import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../services/documents.service';

@Component({
  selector: 'app-statistiques',
  templateUrl: './statistiques.component.html',
  styleUrls: ['./statistiques.component.scss']
})
export class StatistiquesComponent implements OnInit {

  byType: any[] = [];
  documents: any[] = [];
  test: any[] = [];

  constructor(private documentService: DocumentService) {}

  ngOnInit(): void {
    this.documentService.getStatsType().subscribe((files) => {
      this.byType=files;
  });
    this.documentService.getStatsDate().subscribe((data)=>{
      this.documents = data;
    });
    this.documentService.getStatsDeux().subscribe((data)=>{
      this.test = data;
    });

  }


}
