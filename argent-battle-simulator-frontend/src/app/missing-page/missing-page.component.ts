import {Component} from '@angular/core';
import {ComplexRoutingComponent} from "../common/complex.routing.component";
import {ActivatedRoute, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";

@Component({
    selector: 'missing-page',
    templateUrl: './missing-page.component.html',
    styleUrls: ['./missing-page.component.css']
})
export class MissingPageComponent extends ComplexRoutingComponent {

    constructor(private router: Router,
                private route: ActivatedRoute,
                private title: Title) {
        super(router, route, title);
    }
}
