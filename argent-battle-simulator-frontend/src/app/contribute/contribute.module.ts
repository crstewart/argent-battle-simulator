import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ContributeRoutingModule} from "./contribute.routing.module";
import {ContributeComponent} from "./contribute.component";

@NgModule({
    declarations: [
        ContributeComponent
    ],
    imports: [
        CommonModule,
        ContributeRoutingModule
    ]
})
export class ContributeModule {
}
