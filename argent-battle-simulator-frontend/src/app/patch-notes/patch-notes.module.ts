import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {PatchNotesComponent} from "./patch-notes.component";
import {PatchNotesRoutingModule} from "./patch-notes.routing.module";
import {FormsModule} from "@angular/forms";

@NgModule({
    declarations: [
        PatchNotesComponent
    ],
    imports: [
        CommonModule,
        FormsModule,
        PatchNotesRoutingModule
    ]
})
export class PatchNotesModule {}
