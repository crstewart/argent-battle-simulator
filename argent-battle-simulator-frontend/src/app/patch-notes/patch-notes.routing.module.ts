import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {PatchNotesComponent} from "./patch-notes.component";

const routes: Routes = [
    {
        path: '',
        component: PatchNotesComponent,
        data: {title: 'Argent Battle Simulator - Patch Notes'}
    },
    {
        path: ':version',
        component: PatchNotesComponent,
        data: {title: 'Argent Battle Simulator - Version :version Notes'}
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
export class PatchNotesRoutingModule {
}
