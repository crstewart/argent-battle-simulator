import {Router} from "@angular/router";
import {HttpService} from "../service/http.service";
import {SimpleRoutingComponent} from "./simple.routing.component";

export class SimpleHttpComponent extends SimpleRoutingComponent {

    loading: boolean = true;

    constructor(private simpleHttp: HttpService,
                private simpleHttpRouter: Router) {
        super(simpleHttpRouter);
    }
}
