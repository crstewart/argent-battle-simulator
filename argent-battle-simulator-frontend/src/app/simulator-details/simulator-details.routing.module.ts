import {RouterModule, Routes} from "@angular/router";
import {SimulatorDetailsComponent} from "./simulator-details.component";
import {NgModule} from "@angular/core";

const routes: Routes = [
    {
        path: '',
        component: SimulatorDetailsComponent,
        data: {title: 'Argent Battle Simulator - How It Works!'}
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
export class SimulatorDetailsRouterModule {
}
