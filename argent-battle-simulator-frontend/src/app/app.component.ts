import {AfterViewInit, Component, OnInit, ViewChild} from "@angular/core";
import {SimulationResult} from "./model/simulation-result";
import {SimulatorFormComponent} from "./simulator/simulator-form.component";
import {HttpService} from "./service/http.service";
import "rxjs/Rx";

@Component({
    selector: 'app-base',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {

    @ViewChild('simulatorForm')
    simForm: SimulatorFormComponent;

    simulation: SimulationResult;

    constructor(private httpService: HttpService) {
    }

    ngAfterViewInit(): void {
        this.simForm.onSimulationRun
            .subscribe((data: SimulationResult) => this.simulation = data);
    }

    getDownloadLink(id: string): string {
        return this.httpService.getDownloadLink(id)
    }
}
