import {ActivatedRoute, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";
import {SimpleHttpComponent} from "./simple.http.component";
import {HttpService} from "../service/http.service";

export class ComplexHttpComponent extends SimpleHttpComponent {

    constructor(private complexHttp: HttpService,
                private complexRouter: Router,
                private complexRoute: ActivatedRoute,
                private complexTitle: Title) {
        super(complexHttp, complexRouter);
        this.complexRoute.data.subscribe(data => this.complexTitle.setTitle(data.title));
    }
}
