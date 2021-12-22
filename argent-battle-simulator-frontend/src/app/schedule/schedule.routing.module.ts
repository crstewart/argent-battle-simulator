import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {ScheduleComponent} from "./schedule.component";

const routes: Routes = [
    {
        path: '',
        component: ScheduleComponent,
        data: {title: 'Argent Battle Simulator - Schedules for the Current Season'}
    }
];

@NgModule({
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [
        RouterModule
    ]
})
export class ScheduleRoutingModule {
}
