import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SimulationResult} from "../../model/simulation-result";
import {HttpService} from "../../service/http.service";

@Component({
    selector: 'simulator-form',
    templateUrl: './simulator-form.component.html',
    styleUrls: ['./simulator-form.component.css']
})
export class SimulatorFormComponent implements OnInit {

    fighters: string[];

    fighter1: string;
    fighter2: string;

    @Output()
    onSimulationRun: EventEmitter<SimulationResult> = new EventEmitter<SimulationResult>();

    constructor(private httpService: HttpService) {}

    setFighter1(event: Event) {
        this.fighter1 = ""+event;
    }

    setFighter2(event: Event) {
        this.fighter2 = ""+event;
    }

    ngOnInit(): void {
        this.httpService.getFighters().subscribe((data: string[]) => this.fighters = data);
    }

    onSubmit() {
        let simulationResult = this.httpService.getSimulation(this.fighter1, this.fighter2)
            .subscribe((data:SimulationResult) => this.onSimulationRun.emit(data));
    }
}
