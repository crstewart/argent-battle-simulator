import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {BattleLogsComponent} from "./battle-logs.component";

const routes: Routes = [
    {
        path: '',
        component: BattleLogsComponent,
        data: {title: 'Argent Battle Simulator - Battle Logs'}
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
export class BattleLogsRoutingModule {
}
