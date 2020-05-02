import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {SimulationResult} from "../model/simulation-result";
import {Observable} from "rxjs";
import {Fighter} from "../model/fighter";
import {Standings} from "../model/standings";
import {Match} from "../model/match";

@Injectable()
export class HttpService {

    host: string = "http://localhost";

    constructor(private httpClient: HttpClient) {}

    public getSimulation(fighter1Name: string, fighter2Name: string): Observable<SimulationResult> {
        return this.httpClient.get<SimulationResult>("v1/simulation", {
            params: {
                fighter1: fighter1Name,
                fighter2: fighter2Name
            }
        });
    }

    public getFighters(): Observable<string[]> {
        return this.httpClient.get<string[]>("v1/fighters");
    }

    public getDownloadLink(id: string) {
        return "v1/files/" + id + ".txt";
    }

    public getFighter(name: string): Observable<Fighter> {
        return this.httpClient.get<Fighter>("v1/fighters/" + name);
    }

    public getTeams(): Observable<string[]> {
        return this.httpClient.get<string[]>("v1/seasons/1/teams");
    }

    public getStandings(): Observable<Standings[]> {
        return this.httpClient.get<Standings[]>("v1/seasons/1/standings");
    }

    public getRoster(teamName: string): Observable<string[]> {
        return this.httpClient.get<string[]>("v1/seasons/1/rosters?team=" + teamName);
    }

    public getScheduleByWeek(week: number): Observable<Match[]> {
        return this.httpClient.get<Match[]>("v1/seasons/1/schedule?week=" + week);
    }

    public getScheduleByTeam(team: string): Observable<Match[]> {
        return this.httpClient.get<Match[]>("v1/seasons/1/schedule/" + team);
    }

    public getScheduleByTeamAndWeek(team: string, week: number): Observable<Match[]> {
        return this.httpClient.get<Match[]>("v1/seasons/1/schedule/" + team + "?week=" + week);
    }
}
