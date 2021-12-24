import {Router} from "@angular/router";

export class SimpleRoutingComponent {

    loading: boolean = true;

    constructor(private simpleRouter: Router) {
        this.simpleRouter.routeReuseStrategy.shouldReuseRoute = () => false;
    }

    navigate(page: string): void {
        this.loading = true;
        this.simpleRouter.navigateByUrl(page).then(
            success => {},
            error => console.log("An unexpected error occurred!"));
    }
}
