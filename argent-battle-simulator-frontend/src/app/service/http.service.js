"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var HttpService = /** @class */ (function () {
    function HttpService(httpClient, host) {
        if (host === void 0) { host = "http://localhost"; }
        this.httpClient = httpClient;
        this.host = host;
    }
    HttpService.prototype.getSimulation = function (fighter1Name, fighter2Name) {
        var simulationResult = null;
        this.httpClient.get(this.host + "/simulation", {
            params: {
                fighter1: fighter1Name,
                fighter2: fighter2Name
            }
        }).subscribe(function (data) { return simulationResult = data; });
        return simulationResult;
    };
    HttpService.prototype.getFighters = function () {
        var fighters = null;
        this.httpClient.get(this.host + "/fighters")
            .subscribe(function (data) { return fighters = data; });
        return fighters;
    };
    HttpService.prototype.getLog = function (id) {
        var log = null;
        this.httpClient.get(this.host + "/files/" + id + ".txt")
            .subscribe(function (data) { return log = data; });
        return log;
    };
    HttpService = __decorate([
        core_1.Injectable()
    ], HttpService);
    return HttpService;
}());
exports.HttpService = HttpService;
