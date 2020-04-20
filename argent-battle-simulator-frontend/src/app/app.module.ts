import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SimulatorFormComponent} from "./simulator/form/simulator-form.component";
import {HttpService} from "./service/http.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {CharacterDetailsComponent} from "./character-details/character-details.component";
import {SimulatorComponent} from "./simulator/simulator.component";

@NgModule({
    declarations: [
        AppComponent,
        SimulatorComponent,
        CharacterDetailsComponent,
        SimulatorFormComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        AppRoutingModule
    ],
    providers: [HttpService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
