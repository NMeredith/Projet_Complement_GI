import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Document } from '../model/document';
import { Page } from '../model/page';

@Injectable({
  providedIn: 'root',
})
export class DocumentService {

  private employees = new BehaviorSubject<string>('');

  private urlServer:any = {};

  constructor(private readonly http: HttpClient) {

    let baseUrl = `${environment.backend.protocol}://${environment.backend.host}`;
    if (environment.backend.port) {
      baseUrl += `:${environment.backend.port}`;
    }

    // build all backend urls

    Object.keys(environment.backend.endpoints).forEach(
      // @ts-ignore
      k => (this.urlServer[k] = `${baseUrl}${environment.backend.endpoints[k]}`)
    );
    console.log(this.urlServer);

  }

  get employees$(): Observable<string> {
    return this.employees.asObservable();
  }

  updatedEmployeeList(data: string){
    this.employees.next(data);
  }

  fetch(offset : number): Observable<Page> {
    return this.http.get<Page>(this.urlServer.tousLesDocuments.replace(':number', offset));
  }

  // getdata(offset : number): Observable<Page>{
  //   return this.http.get<Page>(this.urlServer.tousLesDocuments.replace(':number', offset)).pipe(
  //    map((data: Page)=> {
  //     return data.map(u => ({content: u.content}))
  //    })
  //   )
  //  }

    // PUTAIN(offset: number): Observable<Document[]> {
    //   return this.http.get(this.urlServer.tousLesDocuments.replace(':number', offset)).pipe(
    //     map(res => {
    //         return res.json().results.map(item => {
    //           return new Document(
    //               item.id,
    //           );
    //         });
    //       });
    //   )

    // }


  getStatsType(): Observable<Document[]> {
    return this.http.get<Document[]>(this.urlServer.statsType);
  }

  search(name: string): Observable<Document[]> {
    return this.http.get<Document[]>(this.urlServer.filterByName.replace(':name', name));
  }


  delete(id: number): Observable<any> {
    return this.http.delete(this.urlServer.unDocument.replace(':id', id));
  }

  create(employe: Document): Observable<Document> {
    return this.http.post<Document>(this.urlServer.tousLesDocuments, employe);
  }

  fetchOne(id: number): Observable<Document> {
    return this.http.get<Document>(this.urlServer.unDocument.replace(':id', id));
  }

  update(employe: Document): Observable<Document> {
    return this.http.put<Document>(this.urlServer.unDocument.replace(':id', employe.id), employe);
  }


}
