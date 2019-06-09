import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Kartice} from './kartice';
import {Korpa} from './korpa';
import{Kupovina} from './kupovina';
import{Checkout} from './checkout';
//import {OktaService} from '../auth/okta.service'
const baseUrl='http://localhost:8083'
@Injectable({
    providedIn: 'root'
  })
export class PaymentManagementService{

    constructor(private http: HttpClient){}
    

    private async request(method: string, url: string, data?: any){
        const result = this.http.request(method, url, {
          body: data,
          responseType: 'json',
          observe: 'body'
          
        });
        return new Promise<any>((resolve, reject) => {
          result.subscribe(resolve as any, reject as any);
        });
      }
      
    AllKartice(){
        return this.request('get',baseUrl+'/rest/kartice/all')
    }
    InsertKartice(kartice:Kartice){
        return this.request('post',baseUrl+'/rest/kartice/insert',kartice)
    }
    GetOneKartica(id:number){
        return this.request('get',baseUrl+'/rest/kartice/'+String(id))
    }
    DeleteOneKartica(id:number){
        return this.request('delete',baseUrl+'/rest/kartice/'+String(id))
    }
    UpdateDatum(id:number,kartice:Kartice){
        return this.request('put',baseUrl+'/rest/kartice/datum/'+String(id),kartice)
    }
    UpdateStanje(id:number,kartice:Kartice){
        return this.request('put',baseUrl+'/rest/kartice/stanje/'+String(id),kartice)
    }
    AllKorpa(){
        return this.request('get',baseUrl+'/rest/korpa/all')
    }
    InsertKorpa(korpa:Korpa){
        return this.request('post',baseUrl+'/rest/korpa/insert',korpa)
    }
    GetOneKorpa(id:number){
        return this.request('get',baseUrl+'/rest/korpa/'+String(id))
    }
    DeleteOneKorpa(id:number){
        return this.request('delete',baseUrl+'/rest/korpa/'+String(id))
    }
    UpdateBrojProizvoda(id:number,korpa:Korpa){
        return this.request('put',baseUrl+'/rest/korpa/'+String(id),korpa)
    }
    AllKupovina(){
        return this.request('get',baseUrl+'/rest/kupovina/all')
    }
    InsertKupovina(kupovina:Kupovina){
        return this.request('post',baseUrl+'/rest/kupovina/insert',kupovina)
    }
    GetOneKupovina(id:number){
        return this.request('get',baseUrl+'/rest/kupovina/'+String(id))
    }
    DeleteOneKupovina(id:number){
        return this.request('delete',baseUrl+'/rest/kupovina/'+String(id))
    }
    UpdateDatumK(id:number,kupovina:Kupovina){
        return this.request('put',baseUrl+'/rest/kupovina/datum/'+String(id),kupovina)
    }
    UpdateKolicina(id:number,kupovina:Kupovina){
        return this.request('put',baseUrl+'/rest/kupovina/datum/kolicina/'+String(id),kupovina)
    }
    InsertKartica(id:number,kupnja:Checkout){
        return this.request('post',baseUrl+'/rest/kartice/insertKartica',kupnja)
    }
}