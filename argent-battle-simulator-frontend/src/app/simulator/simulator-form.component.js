"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var SimulatorFormComponent = /** @class */ (function () {
    function SimulatorFormComponent(httpService) {
        this.httpService = httpService;
    }
    SimulatorFormComponent.prototype.setFighter1 = function (fighter1) {
        this.fighter1 = fighter1;
    };
    SimulatorFormComponent.prototype.setFighter2 = function (fighter2) {
        this.fighter2 = fighter2;
    };
    SimulatorFormComponent.prototype.ngOnInit = function () {
        this.fighters = this.httpService.getFighters();
    };
    SimulatorFormComponent.prototype.onSubmit = function () {
        var simulationResult = this.httpService.getSimulation(this.fighter1, this.fighter2);
        this.onSimulationRun.emit(simulationResult);
    };
    __decorate([
        core_1.Output()
    ], SimulatorFormComponent.prototype, "onSimulationRun", void 0);
    SimulatorFormComponent = __decorate([
        core_1.Component({
            selector: 'simulator-form',
            templateUrl: './simulator-form.component.html',
            styleUrls: ['.simulator-form.component.css']
        })
    ], SimulatorFormComponent);
    return SimulatorFormComponent;
}());
exports.SimulatorFormComponent = SimulatorFormComponent;
