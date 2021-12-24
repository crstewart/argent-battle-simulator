import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {CharacterDetailsComponent} from "./character-details.component";

const routes: Routes = [
    {
        path: '',
        component: CharacterDetailsComponent,
        data: {title: 'Argent Battle Simulator - Fighter Details'}
    },
    {
        path: ':name',
        component: CharacterDetailsComponent,
        data: {title: 'Argent Battle Simulator - :name Details'}
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
export class CharacterDetailsRoutingModule {
}
