import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {CharacterDetailsComponent} from "./character-details.component";
import {CharacterDetailsRoutingModule} from "./character-details.routing.module";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {WidgetsModule} from "../widgets/widgets.module";

@NgModule({
    declarations: [
        CharacterDetailsComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        HttpClientModule,
        WidgetsModule,
        CharacterDetailsRoutingModule
    ],
    providers: [
        HttpClient
    ]
})
export class CharacterDetailsModule {}
