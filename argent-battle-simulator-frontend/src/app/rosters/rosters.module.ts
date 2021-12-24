import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {RostersRoutingModule} from "./rosters.routing.module";
import {RostersComponent} from "./rosters.component";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

@NgModule({
    declarations: [
        RostersComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        HttpClientModule,
        RostersRoutingModule
    ],
    providers: [
        HttpClient
    ]
})
export class RostersModule {}
