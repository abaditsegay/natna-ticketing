import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EventComponent } from './event/event.component';
import { SignupComponent } from './signup/signup.component';
import { EventTicketComponent } from './event-ticket/event-ticket.component';
import { MylistingComponent } from './mylisting/mylisting.component';
import { PaymentOptionComponent } from './payment-option/payment-option.component';
import { AssociateApprovalComponent } from './associate-approval/associate-approval.component';
import { EventOwnerApprovalComponent } from './event-owner-approval/event-owner-approval.component';
import { EventApprovalComponent } from './event-approval/event-approval.component';
import { SportsComponent } from './sports/sports.component';
import { ConcertsComponent } from './concerts/concerts.component';
import { TheatersComponent } from './theaters/theaters.component';
import { AccountOverviewComponent } from './account-overview/account-overview.component';
import { EventRegistrationComponent } from './event-registration/event-registration.component';
import { AccountSettingsComponent } from './account-settings/account-settings.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './reset-password/reset-password.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { TermsOfUseComponent } from './terms-of-use/terms-of-use.component';
import { PrivacyPolicyComponent } from './privacy-policy/privacy-policy.component';
import { PurchasePolicyComponent } from './purchase-policy/purchase-policy.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { FaqComponent } from './faq/faq.component';
import { CareersComponent } from './careers/careers.component';

@NgModule({
  declarations: [
    AppComponent,
    EventComponent,
    SignupComponent,
    EventTicketComponent,
    MylistingComponent,
    PaymentOptionComponent,
    AssociateApprovalComponent,
    EventOwnerApprovalComponent,
    EventApprovalComponent,
    SportsComponent,
    ConcertsComponent,
    TheatersComponent,
    AccountOverviewComponent,
    EventRegistrationComponent,
    AccountSettingsComponent,
    ForgotPasswordComponent,
    ResetPasswordComponent,
    AboutUsComponent,
    TermsOfUseComponent,
    PrivacyPolicyComponent,
    PurchasePolicyComponent,
    ContactUsComponent,
    FaqComponent,
    CareersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
