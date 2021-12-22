import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {SimulationResult} from "../../model/simulation-result";
import {HttpService} from "../../service/http.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {checkIfMirrorMatch} from "../../validator/mirror-match-validator";

@Component({
    selector: 'simulator-form',
    templateUrl: './simulator-form.component.html',
    styleUrls: ['./simulator-form.component.css']
})
export class SimulatorFormComponent implements OnInit {

    form: FormGroup;

    fighters: string[];

    fighter1: string;
    fighter2: string;

    @Output()
    onSimulationRun: EventEmitter<SimulationResult> = new EventEmitter<SimulationResult>();

    constructor(private formBuilder: FormBuilder, private httpService: HttpService) {}

    get formControls() {
        return this.form.controls;
    }

    get isMirrorMatch() {
        return this.formControls.fighter1?.errors?.mirrorMatch || this.formControls.fighter2?.errors?.mirrorMatch;
    }

    setFighter1() {
        this.fighter1 = this.formControls.fighter1?.value;
    }

    setFighter2() {
        this.fighter2 = this.formControls.fighter2?.value;
    }

    ngOnInit(): void {
        this.httpService.getFighters().subscribe((data: string[]) => this.fighters = data);

        this.form = this.formBuilder.group({
            fighter1: new FormControl(this.fighter1, [Validators.required, checkIfMirrorMatch]),
            fighter2: new FormControl(this.fighter2, [Validators.required, checkIfMirrorMatch])
        });
    }

    onSubmit() {
        let simulationResult = this.httpService.getSimulation(this.fighter1, this.fighter2)
            .subscribe((data:SimulationResult) => this.onSimulationRun.emit(data));
    }
}
