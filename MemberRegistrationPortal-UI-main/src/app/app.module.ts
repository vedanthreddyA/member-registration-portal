import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { RegistrationformComponent } from './components/registrationform/registrationform.component';
import { MemberdependentsComponent } from './components/memberdependents/memberdependents.component';
import { DependentsComponent } from './components/dependents/dependents.component';
import { UpdatedependentsComponent } from './components/updatedependents/updatedependents.component';
import { CliamsComponent } from './components/cliams/cliams.component';
import { MemberclaimComponent } from './components/memberclaim/memberclaim.component';
import { ShowdependentsComponent } from './components/showdependents/showdependents.component';
import { WelcomepageComponent } from './components/welcomepage/welcomepage.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegistrationformComponent,
    MemberdependentsComponent,
    DependentsComponent,
    UpdatedependentsComponent,
    CliamsComponent,
    MemberclaimComponent,
    ShowdependentsComponent,
    WelcomepageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
