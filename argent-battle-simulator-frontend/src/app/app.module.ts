import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {SimulatorComponent} from "./simulator/simulator.component";
import {MissingPageComponent} from './missing-page/missing-page.component';
import {WidgetsModule} from "./widgets/widgets.module";
import {HttpService} from "./service/http.service";

@NgModule({
    declarations: [
        // main component
        AppComponent,

        // page components
        SimulatorComponent,
        MissingPageComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        WidgetsModule,
        AppRoutingModule
    ],
    providers: [
        HttpService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
