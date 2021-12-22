import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {SeasonOneComponent} from "./season-one.component";

const routes: Routes = [
    {
        path: '',
        component: SeasonOneComponent,
        data: {title: 'Argent Battle Simulator - Official Season 1 Results'}
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
export class SeasonOneRoutingModule {
}
