import {AfterViewInit, Component, ViewChild} from "@angular/core";
import {SimulatorFormComponent} from "./form/simulator-form.component";
import {SimulationResult} from "../model/simulation-result";
import {HttpService} from "../service/http.service";

@Component({
    selector: 'simulator',
    templateUrl: './simulator.component.html',
    styleUrls: ['./simulator.component.css']
})
export class SimulatorComponent implements AfterViewInit {

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
