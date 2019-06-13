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
  @Input() amount:number=10000;
  constructor(public admins:PaymentManagementService) { }

  ngOnInit() {
  }

  payUp(event:any){
    this.newCheck.amount=event.target.amount.value;
    this.pay();
  }
  async pay(){
    const data = await this.admins.PayUp(this.newCheck);
  }
}
