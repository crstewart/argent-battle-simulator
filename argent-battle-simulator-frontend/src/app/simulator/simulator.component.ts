import {AfterViewInit, Component, ViewChild} from "@angular/core";
import {SimulationResult} from "../model/simulation-result";
import {HttpService} from "../service/http.service";
import {SimulatorFormComponent} from "../widgets/simulator-form/simulator-form.component";

@Component({
    selector: 'simulator',
    templateUrl: './simulator.component.html',
    styleUrls: ['./simulator.component.css']
})
export class SimulatorComponent implements AfterViewInit {

    @ViewChild('simulatorForm') simulatorForm: SimulatorFormComponent;

    simulation: SimulationResult;

    constructor(private httpService: HttpService) {
    }

    ngAfterViewInit(): void {
        this.simulatorForm.onSimulationRun
            .subscribe((data: SimulationResult) => this.simulation = data);
    }

    getDownloadLink(id: string): string {
        return this.httpService.getDownloadLink(id)
    }
}
