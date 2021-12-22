import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {StandingsRoutingModule} from "./standings.routing.module";
import {StandingsComponent} from "./standings.component";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@NgModule({
    declarations: [
        StandingsComponent
    ],
    imports: [
        CommonModule,
        HttpClientModule,
        StandingsRoutingModule
    ],
    providers: [
        HttpClient
    ]
})
export class StandingsModule {}
