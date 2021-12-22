import {SimpleRoutingComponent} from "./simple.routing.component";
import {ActivatedRoute, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";

export class ComplexRoutingComponent extends SimpleRoutingComponent {

    constructor(private complexRouter: Router,
                private complexRoute: ActivatedRoute,
                private complexTitle: Title) {
        super(complexRouter);
        this.complexRoute.data.subscribe(data => this.complexTitle.setTitle(data.title));
    }
}
