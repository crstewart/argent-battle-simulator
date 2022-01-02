import {Component} from "@angular/core";
import {HttpService} from "../service/http.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";
import {ComplexRoutingComponent} from "../common/complex.routing.component";

@Component({
    selector: 'character-details',
    templateUrl: './blog.component.html',
    styleUrls: ['./blog.component.css'],
    providers: [HttpService]
})
export class BlogComponent extends ComplexRoutingComponent {

    constructor(private router: Router,
                private route: ActivatedRoute,
                private title: Title) {
        super(router, route, title);
    }
}
