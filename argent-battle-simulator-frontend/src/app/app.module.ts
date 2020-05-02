import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {SimulatorFormComponent} from "./simulator/form/simulator-form.component";
import {HttpService} from "./service/http.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CharacterDetailsComponent} from "./character-details/character-details.component";
import {SimulatorComponent} from "./simulator/simulator.component";
import {SimulatorDetailsComponent} from "./simulator-details/simulator-details.component";
import {PatchNotesComponent} from "./patch-notes/patch-notes.component";
import {StandingsComponent} from "./standings/standings.component";
import {RostersComponent} from "./rosters/rosters.component";
import {ScheduleComponent} from "./schedule/schedule.component";

@NgModule({
    declarations: [
        AppComponent,
        SimulatorComponent,
        SimulatorDetailsComponent,
        CharacterDetailsComponent,
        PatchNotesComponent,
        SimulatorFormComponent,
        StandingsComponent,
        RostersComponent,
        ScheduleComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule,
        AppRoutingModule
    ],
    providers: [HttpService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
