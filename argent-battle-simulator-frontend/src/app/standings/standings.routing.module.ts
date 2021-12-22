import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {StandingsComponent} from "./standings.component";

const routes: Routes = [
    {
        path: '',
        component: StandingsComponent,
        data: {title: 'Argent Battle Simulator - Current Standings'}
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
export class StandingsRoutingModule {
}
