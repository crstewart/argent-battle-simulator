import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";
import {ComplexRoutingComponent} from "../common/complex.routing.component";

@Component({
    selector: 'simulator-details',
    templateUrl: './simulator-details.component.html',
    styleUrls: ['./simulator-details.component.css']
})
export class SimulatorDetailsComponent extends ComplexRoutingComponent {

    constructor(private router: Router,
                private route: ActivatedRoute,
                private title: Title) {
        super(router, route, title);
    }
}
