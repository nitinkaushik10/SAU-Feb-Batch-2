import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http: HttpClient) {}
  
  hello=():Observable<any>=>{
    return this.http.get<any>("/ordermgmt/hello")
  }

  getUser=():Observable<any>=>{
    return this.http.get<any>("/ordermgmt/payment")
  }

  payCredit=(creditPayment:number):Observable<any>=>{
    console.log(creditPayment);
    return this.http.get<any>(`/ordermgmt/payment/set/${creditPayment}`);
  }

}
