import { TicketComponent } from './ticket/ticket.component';
import { FaqComponent } from './faq/faq.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { EventComponent } from './events/events.component';
import { SportsComponent } from './sports/sports.component';
import { ConcertsComponent } from './concerts/concerts.component';
import { TheatersComponent } from './theaters/theaters.component';
import { AccountOverviewComponent } from './account-overview/account-overview.component';
import { EventRegistrationComponent } from './event-registration/event-registration.component';
import { CareersComponent } from './careers/careers.component';

const routes : Routes = [
      {
        path: '',
        component: EventComponent
      },
      {
        path: 'sports',
        component: SportsComponent,
      },
      {
        path: 'concerts',
        component: ConcertsComponent,
      },
      {
        path: 'theaters',
        component: TheatersComponent,
      },
      {
        path: 'accountoverview',
        component: AccountOverviewComponent
      },
      {
        path: 'eventregistration',
        component: EventRegistrationComponent
      },
      {
        path: 'careers',
        component: CareersComponent
      },
      {
        path: 'faq',
        component: FaqComponent
      },
      {
        path: 'ticket',
        component: TicketComponent
      },
      {
        path: '', 
        redirectTo: '', 
        pathMatch: 'full' 
      }
     ]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
}
