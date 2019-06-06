import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {PaymentManagementService} from '../_services/management/payment-management.service';
import {Kartice} from '../_services/management/kartice';
import { ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';
@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.css']
})
export class AdminPanelComponent implements OnInit {

  @Input() kartica:Kartice;
  @Output() onDeleted = new EventEmitter<boolean>();
  newKartica:Kartice=new Kartice();
  kartice:Kartice;
  nizkartica:Kartice[];
  constructor(public admins:PaymentManagementService,private route: ActivatedRoute,private location: Location) { }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.nizkartica=[];
    this.test();
   // this.refreshKartice();
  }

  async test(){
    const data= await this.admins.AllKartice();
    console.log(data);
    this.nizkartica=data;
  }

  //async update(){
    //const data=await this.admins.InsertKartice(this.kartice);

//  }
  submitKartica(event:any){
    this.newKartica.broj=event.target.broj.value;
    this.newKartica.datum_isteka=event.target.datum_isteka.value;
    this.newKartica.korisnik_kartice_id=event.target.korisnik_kartice_id.value;
    this.newKartica.nosilac_kartice=event.target.nosilac_kartice.value;
    this.newKartica.security_code=event.target.security_code.value;
    this.newKartica.stanje=event.target.stanje.value;
    this.newKartica.tip=event.target.tip.value;
    this.create();
    console.log(this.newKartica);
  }

  async create(){
    const data = await this.admins.InsertKartice(this.newKartica);
    console.log("done");
  }
  /*async refreshKartice(){
    const data = await this.admins.AllKartice();
    if (data!=undefined && data._embedded!=undefined)
    this.nizkartica=data._embedded.karticeEntities;
    else this.nizkartica=[]
  }*/

  async deleteKartica(id:number){
    await this.admins.DeleteOneKartica(this.kartice.id);
  }
}
