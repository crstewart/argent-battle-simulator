import {Component, OnInit} from "@angular/core";
import {HttpService} from "../service/http.service";
import {Standings} from "../model/standings";
import {ActivatedRoute, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";
import {ComplexHttpComponent} from "../common/complex.http.component";

@Component({
    selector: 'season-one',
    templateUrl: './season-one.component.html',
    styleUrls: ['./season-one.component.css']
})
export class SeasonOneComponent extends ComplexHttpComponent implements OnInit {

    powerDivisionStandings: Standings[] = [];
    mastersDivisionStandings: Standings[] = [];

    constructor(private http: HttpService,
                private router: Router,
                private route: ActivatedRoute,
                private title: Title) {
        super(http, router, route, title);
    }

    ngOnInit(): void {
        this.http.getSeasonOneStandings().subscribe((data: Standings[]) => this.arrangeStandings(data));
    }

    getPowerDivisionLeaderWinDifferential(): number {
        if (this.powerDivisionStandings.length === 0) {
            return 0;
        }

        let leaderStandings = this.powerDivisionStandings[0];
        return leaderStandings.wins - leaderStandings.losses;
    }

    getMastersDivisionLeaderWinDifferential(): number {
        if (this.mastersDivisionStandings.length === 0) {
            return 0;
        }

        let leaderStandings = this.mastersDivisionStandings[0];
        return leaderStandings.wins - leaderStandings.losses;
    }

    private arrangeStandings(standings: Standings[]) {
        for (let teamStandings of standings) {
            if (teamStandings.division === "Power Division") {
                this.powerDivisionStandings.push(teamStandings);
            } else {
                this.mastersDivisionStandings.push(teamStandings);
            }
        }

        SeasonOneComponent.sortStandings(this.powerDivisionStandings);
        SeasonOneComponent.sortStandings(this.mastersDivisionStandings);
    }

    private static sortStandings(standings: Standings[]) {
        standings.sort((a, b) => {
            if (a.winPercentage > b.winPercentage) return -1;
            if (a.winPercentage < b.winPercentage) return 1;
            if (a.team > b.team) return 1;
            if (a.team < b.team) return -1;
            return 0;
        });
    }
}
