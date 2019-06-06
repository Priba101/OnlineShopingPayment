import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule, NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {  RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {APP_BASE_HREF} from '@angular/common';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CheckOutPreviewComponent } from './check-out-preview/check-out-preview.component';
import { CheckOutFinalComponent } from './check-out-preview/check-out-final/check-out-final.component';
import { ItemPreviewComponent } from './item-preview/item-preview.component';
import { LoginComponent } from './login/login.component';
import { MainPageComponent } from './main-page/main-page.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
//import { Okta } from './_services/auth/okta.service/okta.service.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CheckOutPreviewComponent,
    CheckOutFinalComponent,
    ItemPreviewComponent,
    LoginComponent,
    MainPageComponent,
    AdminPanelComponent
    //Okta.ServiceComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgbModule,     
    HttpClientModule,        
    RouterModule.forRoot([
      {path:'', redirectTo:'/main-page',pathMatch:'full'},
      {path:'main-page',component:MainPageComponent},
      {path:'item-preview', component: ItemPreviewComponent},
      {path:'check-out-preview', component: CheckOutPreviewComponent},
      {path:'check-out-final', component: CheckOutFinalComponent},
      {path:'login',component:LoginComponent},
      {path:'admin',component:AdminPanelComponent}
    ])
  ],
  providers: [NgbActiveModal,{provide: APP_BASE_HREF, useValue: '/'}],
  bootstrap: [AppComponent],
  entryComponents: [LoginComponent],
  exports: [LoginComponent]
})
export class AppModule { }
