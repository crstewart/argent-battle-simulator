import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {SimulationResult} from "../model/simulation-result";
import {Observable} from "rxjs";

@Injectable()
export class HttpService {

    host: string = "http://localhost";

    constructor(private httpClient: HttpClient) {}

    public getSimulation(fighter1Name: string, fighter2Name: string): Observable<SimulationResult> {
        return this.httpClient.get<SimulationResult>("simulation", {
            params: {
                fighter1: fighter1Name,
                fighter2: fighter2Name
            }
        });
    }

    public getFighters(): Observable<string[]> {
        return this.httpClient.get<string[]>("fighters");
    }

    getDownloadLink(id: string) {
        return "files/" + id + ".txt";
    }
}
