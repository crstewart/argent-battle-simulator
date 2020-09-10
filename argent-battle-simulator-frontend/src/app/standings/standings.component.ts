import {Component, OnInit} from "@angular/core";
import {HttpService} from "../service/http.service";
import {Standings} from "../model/standings";

@Component({
    selector: 'standings',
    templateUrl: './standings.component.html',
    styleUrls: ['./standings.component.css']
})
export class StandingsComponent implements OnInit {

    shadowDivisionStandings: Standings[] = [];
    chaosDivisionStandings: Standings[] = [];

    constructor(private httpService: HttpService) {
    }

    ngOnInit(): void {
        this.httpService.getStandings().subscribe((data: Standings[]) => this.arrangeStandings(data));
    }

    getShadowDivisionLeaderWinDifferential(): number {
        if (this.shadowDivisionStandings.length === 0) {
            return 0;
        }

        let leaderStandings = this.shadowDivisionStandings[0];
        return leaderStandings.wins - leaderStandings.losses;
    }

    getChaosDivisionLeaderWinDifferential(): number {
        if (this.chaosDivisionStandings.length === 0) {
            return 0;
        }

        let leaderStandings = this.chaosDivisionStandings[0];
        return leaderStandings.wins - leaderStandings.losses;
    }

    private arrangeStandings(standings: Standings[]) {
        for (let teamStandings of standings) {
            if (teamStandings.division === "Shadow Division") {
                this.shadowDivisionStandings.push(teamStandings);
            } else {
                this.chaosDivisionStandings.push(teamStandings);
            }
        }

        StandingsComponent.sortStandings(this.shadowDivisionStandings);
        StandingsComponent.sortStandings(this.chaosDivisionStandings);
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
