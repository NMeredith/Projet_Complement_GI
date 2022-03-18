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

  fetch(offset : number): Observable<Page> {
    return this.http.get<Page>(this.urlServer.tousLesDocuments.replace(':number', offset));
  }


  delete(id: number): Observable<any> {
    return this.http.delete(this.urlServer.unDocument.replace(':id', id));
  }

  create(doc: Document): Observable<any> {
    return this.http.post(this.urlServer.archiver, doc);
  }

  read(id: number): Observable<any> {
    return this.http.get(this.urlServer.unDocument.replace(':id', id));
  }

  getStatsType(): Observable<any> {
    return this.http.get<any>(this.urlServer.statsType);
  }
  getStatsDate(): Observable<any> {
    return this.http.get<any>(this.urlServer.statsDate);
  }
  getStatsDeux(): Observable<any> {
    return this.http.get<any>(this.urlServer.statsDeux);
  }
}
