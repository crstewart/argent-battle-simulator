import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {SimulationResult} from "../model/simulation-result";
import {Observable} from "rxjs";
import {Fighter} from "../model/fighter";

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

    public getDownloadLink(id: string) {
        return "files/" + id + ".txt";
    }

    public getFighter(name: string): Observable<Fighter> {
        return this.httpClient.get<Fighter>("fighters/" + name);
    }
}
