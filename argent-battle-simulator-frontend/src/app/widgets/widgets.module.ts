import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {CharacterImageComponent} from "./character-image/character-image.component";
import {SimulatorFormComponent} from "./simulator-form/simulator-form.component";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
    declarations: [
        CharacterImageComponent,
        SimulatorFormComponent
    ],
    imports: [
        CommonModule,
        ReactiveFormsModule
    ],
    exports: [
        CharacterImageComponent,
        SimulatorFormComponent
    ]
})
export class WidgetsModule {
}
