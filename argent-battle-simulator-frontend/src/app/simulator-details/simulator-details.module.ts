import {NgModule} from "@angular/core";
import {SimulatorDetailsComponent} from "./simulator-details.component";
import {CommonModule} from "@angular/common";
import {SimulatorDetailsRouterModule} from "./simulator-details.routing.module";

@NgModule({
    declarations: [
        SimulatorDetailsComponent
    ],
    imports: [
        CommonModule,
        SimulatorDetailsRouterModule
    ]
})
export class SimulatorDetailsModule {}
