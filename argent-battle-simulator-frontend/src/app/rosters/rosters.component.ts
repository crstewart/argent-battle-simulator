import {Component, OnInit} from "@angular/core";
import {HttpService} from "../service/http.service";

@Component({
    selector: 'character-details',
    templateUrl: './rosters.component.html',
    styleUrls: ['./rosters.component.css']
})
export class RostersComponent implements OnInit {

    teams: string[];
    fighters: string[];

    selectedTeam: string;

    constructor(private httpService: HttpService) {}

    ngOnInit(): void {
        this.httpService.getTeams().subscribe((data: string[]) => this.teams = data);
    }

    setTeam(event: Event): void {
        let teamName = ""+event;
        this.selectedTeam = teamName;
        this.httpService.getRoster(teamName).subscribe((data: string[]) => this.fighters = data);
    }
}
