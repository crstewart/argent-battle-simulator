import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {RostersComponent} from "./rosters.component";

const routes: Routes = [
    {
        path: '',
        component: RostersComponent,
        data: {title: 'Argent Battle Simulator - Rosters for the Current Season'}
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
export class RostersRoutingModule {
}
