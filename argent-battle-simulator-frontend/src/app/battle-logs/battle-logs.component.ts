import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {ComplexRoutingComponent} from "../common/complex.routing.component";
import {Title} from "@angular/platform-browser";

@Component({
    selector: 'battle-logs',
    templateUrl: './battle-logs.component.html',
    styleUrls: ['./battle-logs.component.css']
})
export class BattleLogsComponent extends ComplexRoutingComponent {

    constructor(private router: Router,
                private route: ActivatedRoute,
                private title: Title) {
        super(router, route, title);
    }
}
