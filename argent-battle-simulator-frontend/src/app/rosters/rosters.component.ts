import {Component} from "@angular/core";
import {HttpService} from "../service/http.service";
import {ComplexHttpComponent} from "../common/complex.http.component";
import {ActivatedRoute, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";

@Component({
    selector: 'rosters',
    templateUrl: './rosters.component.html',
    styleUrls: ['./rosters.component.css'],
    providers: [HttpService]
})
export class RostersComponent extends ComplexHttpComponent {

    teams: string[];
    fighters: string[];

    selectedTeam: string;

    constructor(private http: HttpService,
                private router: Router,
                private route: ActivatedRoute,
                private title: Title) {
        super(http, router, route, title);
    }

    ngOnInit(): void {
        this.http.getTeams().subscribe((data: string[]) => this.teams = data);
    }

    setTeam(event: Event): void {
        let teamName = ""+event;
        this.selectedTeam = teamName;
        this.http.getRoster(teamName).subscribe((data: string[]) => this.fighters = data);
    }
}
