import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BlogRoutingModule} from "./blog.routing.module";
import {BlogComponent} from "./blog.component";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@NgModule({
    declarations: [
        BlogComponent
    ],
    imports: [
        CommonModule,
        HttpClientModule,
        BlogRoutingModule
    ],
    providers: [
        HttpClient
    ]
})
export class BlogModule {
}
