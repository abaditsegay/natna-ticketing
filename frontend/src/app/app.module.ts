import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule }    from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EventComponent } from './events/events.component';
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
import { CareersComponent } from './careers/careers.component';
import { FaqComponent } from './faq/faq.component';
import { TicketComponent } from './ticket/ticket.component';
import { BookingComponent } from './booking/booking.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { AssociateRegistrationComponent } from './associate-registration/associate-registration.component';
import { EventOwnerRegistrationComponent } from './event-owner-registration/event-owner-registration.component';
import { EventDetailsComponent } from './event-details/event-details.component';
import { RoleMgmtComponent } from './role-mgmt/role-mgmt.component';
import { EventReviewComponent } from './event-review/event-review.component';
import { AssociateReviewComponent } from './associate-review/associate-review.component';
import { EventOwnerReviewComponent } from './event-owner-review/event-owner-review.component';

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
    CareersComponent,
    FaqComponent,
    TicketComponent,
    BookingComponent,
    UserRegistrationComponent,
    AssociateRegistrationComponent,
    EventOwnerRegistrationComponent,
    EventDetailsComponent,
    RoleMgmtComponent,
    EventReviewComponent,
    AssociateReviewComponent,
    EventOwnerReviewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
