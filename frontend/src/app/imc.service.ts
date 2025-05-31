import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ImcRecord } from './ImcRecord';

@Injectable({
  providedIn: 'root'
})
export class ImcService {


  private apiUrl = 'http://localhost:8080/api/imc';

  constructor(private http: HttpClient) {}

  enregistrerIMC(imcData: ImcRecord) {
    return this.http.post(this.apiUrl, imcData);
  }
}
