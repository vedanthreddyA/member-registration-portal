import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CliamsComponent } from './components/cliams/cliams.component';
import { DependentsComponent } from './components/dependents/dependents.component';
import { HomeComponent } from './components/home/home.component';
import { MemberclaimComponent } from './components/memberclaim/memberclaim.component';
import { MemberdependentsComponent } from './components/memberdependents/memberdependents.component';
import { RegistrationformComponent } from './components/registrationform/registrationform.component';
import { ShowdependentsComponent } from './components/showdependents/showdependents.component';
import { UpdatedependentsComponent } from './components/updatedependents/updatedependents.component';
import { WelcomepageComponent } from './components/welcomepage/welcomepage.component';

const routes: Routes = [
  {path: '', redirectTo: 'registration', pathMatch:'full'},
  {path : "home", component: HomeComponent },
  {path : "registration", component: RegistrationformComponent},
  {path : "dependents/:response", component: MemberdependentsComponent},
  {path : "updatemember", component: DependentsComponent},
  {path : "updatedependents", component: UpdatedependentsComponent},
  {path : "claim", component: CliamsComponent},
  {path : "memberclaim/:memberId", component: MemberclaimComponent},
  {path : "showdependents/:memberId", component : ShowdependentsComponent},
  {path : "welcomepage", component : WelcomepageComponent}

 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
