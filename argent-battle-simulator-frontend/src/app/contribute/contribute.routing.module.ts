import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {ContributeComponent} from "./contribute.component";

const routes: Routes = [
    {
        path: '',
        component: ContributeComponent,
        data: {title: 'Argent Battle Simulator - Looking for Contributors!'}
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
export class ContributeRoutingModule {
}
