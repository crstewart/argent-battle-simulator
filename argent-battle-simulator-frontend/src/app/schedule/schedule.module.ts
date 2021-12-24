import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ScheduleRoutingModule} from "./schedule.routing.module";
import {ScheduleComponent} from "./schedule.component";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

@NgModule({
    declarations: [
        ScheduleComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        HttpClientModule,
        ScheduleRoutingModule
    ],
    providers: [
        HttpClient
    ]
})
export class ScheduleModule {}
