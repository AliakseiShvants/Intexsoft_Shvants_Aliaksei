import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MainComponent } from './main/main.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { InfoComponent } from './info/info.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { LogonComponent } from './logon/logon.component';
import { ShorterComponent } from './shorter/shorter.component';
import { StatisticsComponent } from './statistics/statistics.component';
import { BackComponent } from './back/back.component';
import { LogoutComponent } from './logout/logout.component';
import { OnMainComponent } from './on-main/on-main.component';
import { UrlInfoComponent } from './url-info/url-info.component';
import { EditComponent } from './edit/edit.component';


const appRoutes: Routes = [
  { path: '', component: MainComponent },
  { path: 'info', component: InfoComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'url-info', component: UrlInfoComponent },
  { path: 'logon', component: LogonComponent },
  { path: 'shorter', component: ShorterComponent },
  { path: 'statistics', component: StatisticsComponent },
  { path: 'edit', component: EditComponent }
  // { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MainComponent,
    LoginComponent,
    LogonComponent,
    RegisterComponent,
    ShorterComponent,
    StatisticsComponent,
    InfoComponent,
    BackComponent,
    LogoutComponent,
    OnMainComponent,
    UrlInfoComponent,
    EditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
