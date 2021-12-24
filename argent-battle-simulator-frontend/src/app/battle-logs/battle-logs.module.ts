import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {BattleLogsRoutingModule} from "./battle-logs.routing.module";
import {BattleLogsComponent} from "./battle-logs.component";

@NgModule({
    declarations: [
        BattleLogsComponent
    ],
    imports: [
        CommonModule,
        BattleLogsRoutingModule
    ]
})
export class BattleLogsModule {}
