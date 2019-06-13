import { Component, OnInit, Input } from '@angular/core';
import { Checkout } from 'src/app/_services/management/checkout';
import { PaymentManagementService } from 'src/app/_services/management/payment-management.service';
import { Kartice } from 'src/app/_services/management/kartice';

@Component({
  selector: 'app-check-out-final',
  templateUrl: './check-out-final.component.html',
  styleUrls: ['./check-out-final.component.css']
})
export class CheckOutFinalComponent implements OnInit {

  @Input() id:number;
  kartice:Kartice;
  newKartica:Kartice=new Kartice();
  kupnja:Checkout=new Checkout();
  constructor(public checkout:PaymentManagementService) { }

  ngOnInit() {
  }

  submitCheckout(event:any){
    this.kupnja.name=event.target.name.value;
    this.kupnja.address=event.target.address.value;
    this.kupnja.email=event.target.email.value;
    this.kupnja.city=event.target.check.value;
    this.kupnja.zip=event.target.zip.value;
    this.kupnja.cardNumber=event.target.cardNumber.value;
    this.kupnja.securityCode=event.target.securityCode.value;
    this.kupnja.expirationMonth=event.target.expirationMonth.value;
    this.kupnja.expirationYear=event.target.expirationYear.value;
    console.log(this.kupnja);
    this.dodajKarticu();
  }
  async dodajKarticu(){
    const data = await this.checkout.InsertKartica(this.id,this.kupnja);
    console.log("done");
  }
}
