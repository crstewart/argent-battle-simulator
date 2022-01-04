import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {BlogComponent} from "./blog.component";

const routes: Routes = [
    {
        path: '',
        component: BlogComponent,
        data: {title: 'Argent Battle Simulator - Developer Blog'}
    },
    {
        path: ':entry',
        component: BlogComponent,
        data: {title: 'Argent Battle Simulator - Developer Blog (:date)'}
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
export class BlogRoutingModule {
}
