import {AfterViewInit, Component, ViewChild} from "@angular/core";
import {SimulationResult} from "../model/simulation-result";
import {HttpService} from "../service/http.service";
import {SimulatorFormComponent} from "../widgets/simulator-form/simulator-form.component";
import {ComplexHttpComponent} from "../common/complex.http.component";
import {ActivatedRoute, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";

@Component({
    selector: 'simulator',
    templateUrl: './simulator.component.html',
    styleUrls: ['./simulator.component.css'],
    providers: [HttpService]
})
export class SimulatorComponent extends ComplexHttpComponent implements AfterViewInit {

    @ViewChild('simulatorForm') simulatorForm: SimulatorFormComponent;

    simulation: SimulationResult;

    constructor(private http: HttpService,
                private router: Router,
                private route: ActivatedRoute,
                private title: Title) {
        super(http, router, route, title);
    }

    ngAfterViewInit(): void {
        this.simulatorForm.onSimulationRun
            .subscribe((data: SimulationResult) => this.simulation = data);
    }

    getDownloadLink(id: string): string {
        return this.http.getDownloadLink(id)
    }
}
