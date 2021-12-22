import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {SeasonOneRoutingModule} from "./season-one.routing.module";
import {SeasonOneComponent} from "./season-one.component";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@NgModule({
    declarations: [
        SeasonOneComponent
    ],
    imports: [
        CommonModule,
        HttpClientModule,
        SeasonOneRoutingModule
    ],
    providers: [
        HttpClient
    ]
})
export class SeasonOneModule {}
