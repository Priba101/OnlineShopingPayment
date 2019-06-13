import { Component, OnInit, Input } from '@angular/core';
import { Checkout } from '../_services/management/checkout';
import { PaymentManagementService } from '../_services/management/payment-management.service';

@Component({
  selector: 'app-check-out-preview',
  templateUrl: './check-out-preview.component.html',
  styleUrls: ['./check-out-preview.component.css']
})
export class CheckOutPreviewComponent implements OnInit {


  newCheck:Checkout=new Checkout();
  @Input() amount:number;
  constructor(public admins:PaymentManagementService) { }

  ngOnInit() {
  }

  payUp(event:any,amount:number){
    this.newCheck.cardNumber=event.target.cardNumber.value;
    this.newCheck.securityCode=event.target.cardNumber.value;
    this.newCheck.expirationMonth=event.target.expirationMonth.value;
    this.newCheck.expirationYear=event.target.expirationYear.value;
    this.pay(this.amount);
  }
  async pay(amount:number){
    const data = await this.admins.PayUp(this.amount);
  }
}
