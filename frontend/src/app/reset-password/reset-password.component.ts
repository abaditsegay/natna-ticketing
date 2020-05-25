import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit{
  
  formUpdatePassword: FormGroup;
  formResetPassword: FormGroup;
  closeResult: string = "";

  constructor(private formBuilder: FormBuilder){}

  ngOnInit(){
    this.formResetPassword = this.formBuilder.group({
      resetPasswordEmail: this.formBuilder.control(''),
      resetPasswordPassword: this.formBuilder.control(''),
    });
    this.formUpdatePassword = this.formBuilder.group({
      newPassword: this.formBuilder.control(''),
      confirmNewPassword: this.formBuilder.control('')
    })
  }

  updatePassword(updatePasswordContent: any) {
    console.log("Test log");
  }
}
