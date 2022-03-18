import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DocumentService } from '../services/documents.service';

@Component({
  selector: 'app-details-doc',
  templateUrl: './details-doc.component.html',
  styleUrls: ['./details-doc.component.scss']
})
export class DetailsDocComponent implements OnInit {

  currentDoc: any = null;
  message = '';

  constructor(private listDocumentService: DocumentService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    var stringToConvert = this.route.snapshot.paramMap.get('id');
    var numberValue = Number(stringToConvert);
    this.getDocument(numberValue);
  }

  getDocument(id: number): void {
    this.listDocumentService.read(id).subscribe(
      (card) => {
        this.currentDoc = card;
        console.log(card);
      },
      (error) => {
        console.log(error);
      }
    );
  }
  deleteDocument(): void {
    this.listDocumentService.delete(this.currentDoc.id).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(['/list-doc']);
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
