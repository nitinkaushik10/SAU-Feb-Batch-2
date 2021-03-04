import { Component, OnInit } from '@angular/core';
import { payment } from 'src/app/model/payment';
import { PaymentService} from '../../payment.service'


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  creditPayment!: number;
  user!: payment;

  constructor(private paymentService :PaymentService) { }

  ngOnInit(): void {
    // this.paymentService.hello().subscribe((response)=>{
    //   console.log(response);
    this.paymentService.getUser().subscribe((response)=>{
      console.log(response);
      this.user = response;
   })
    

    
  }

   PayCredit():void{
    console.log("credit to be paid"+this.creditPayment);
    this.paymentService.payCredit(this.creditPayment).subscribe((response)=>{
      console.log("payment successful");
      window.location.reload();
    })
    
  }
    


}
