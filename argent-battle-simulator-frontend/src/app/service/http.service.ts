import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {SimulationResult} from "../model/simulation-result";
import {Observable} from "rxjs";
import {Fighter} from "../model/fighter";
import {Standings} from "../model/standings";
import {Match} from "../model/match";
import {BlogEntry} from "../model/blog-entry";

@Injectable()
export class HttpService {

    host: string = "http://localhost";

    constructor(private httpClient: HttpClient) {
    }

    public getSimulation(fighter1Name: string, fighter2Name: string): Observable<SimulationResult> {
        return this.httpClient.get<SimulationResult>("v1/simulation", {
            params: {
                fighter1: this.getCanonicalId(fighter1Name),
                fighter2: this.getCanonicalId(fighter2Name)
            }
        });
    }

    public getDownloadLink(id: string) {
        return `v1/files/${id}.txt`;
    }

    public getFighters(): Observable<string[]> {
        return this.httpClient.get<string[]>("v1/fighters");
    }

    public getFighter(name: string): Observable<Fighter> {
        return this.httpClient.get<Fighter>(`v1/fighters/${this.getCanonicalId(name)}`);
    }

    public getSeasonOneStandings(): Observable<Standings[]> {
        return this.httpClient.get<Standings[]>("v1/seasons/1/standings");
    }

    public getTeams(): Observable<string[]> {
        return this.httpClient.get<string[]>("v1/seasons/2/teams");
    }

    public getStandings(): Observable<Standings[]> {
        return this.httpClient.get<Standings[]>("v1/seasons/2/standings");
    }

    public getRoster(team: string): Observable<string[]> {
        return this.httpClient.get<string[]>(`v1/seasons/2/rosters?team=${this.getCanonicalId(team)}`);
    }

    public getWeeks(): Observable<number[]> {
        return this.httpClient.get<number[]>("v1/seasons/2/weeks");
    }

    public getScheduleByWeek(week: number): Observable<Match[]> {
        return this.httpClient.get<Match[]>(`v1/seasons/2/schedule?week=${week}`);
    }

    public getScheduleByTeam(team: string): Observable<Match[]> {
        return this.httpClient.get<Match[]>(`v1/seasons/2/schedule?teamName=${this.getCanonicalId(team)}`);
    }

    public getScheduleByTeamAndWeek(team: string, week: number): Observable<Match[]> {
        return this.httpClient.get<Match[]>(`v1/seasons/2/schedule?teamName=${this.getCanonicalId(team)}&week=${week}`);
    }

    public getBlogEntries(): Observable<BlogEntry[]> {
        return this.httpClient.get<BlogEntry[]>(`v1/blogs`);
    }

    public getBlogEntryByNumber(entryNumber: number): Observable<string> {
        return this.httpClient.get(`v1/blogs/${entryNumber}`, {responseType: 'text'});
    }

    private getCanonicalId(value: string): string {
        return value.trim().replace(/\s+&\s+/gi, '_and_')
            .replace(/\s+/gi, '_');
    }
}
