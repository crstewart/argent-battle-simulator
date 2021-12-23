import {Component, OnInit} from "@angular/core";
import {HttpService} from "../service/http.service";
import {Match} from "../model/match";
import {ActivatedRoute, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";
import {ComplexHttpComponent} from "../common/complex.http.component";

@Component({
    selector: 'schedule',
    templateUrl: './schedule.component.html',
    styleUrls: ['./schedule.component.css'],
    providers: [HttpService]
})
export class ScheduleComponent extends ComplexHttpComponent implements OnInit {

    teams: string[];
    weeks: number[];

    selectedTeam: string;
    selectedWeek: number;

    schedule: Match[];

    constructor(private http: HttpService,
                private router: Router,
                private route: ActivatedRoute,
                private title: Title) {
        super(http, router, route, title);
    }

    ngOnInit(): void {
        this.http.getTeams().subscribe((data: string[]) => this.teams = data.filter((team) => team !== ""));
        this.http.getWeeks().subscribe((data: number[]) => this.weeks = data);
    }

    setTeam(event: Event) {
        this.selectedTeam = ""+event;
        this.fetchSchedule();
    }

    setWeek(event: Event) {
        this.selectedWeek = Number(event);
        this.fetchSchedule();
    }

    getHeader(): string {
        if (this.selectedTeam && !this.selectedWeek) {
            return "Full schedule for " + this.selectedTeam;
        } else if (!this.selectedTeam && this.selectedWeek) {
            return "Schedule for Week " + this.selectedWeek;
        } else {
            return "Schedule for " + this.selectedTeam + ", Week " + this.selectedWeek;
        }
    }

    private fetchSchedule() {
        if (!this.selectedTeam && !this.selectedWeek) {
            this.schedule = [];
        } else if (this.selectedTeam && !this.selectedWeek) {
            this.http.getScheduleByTeam(this.selectedTeam).subscribe((data: Match[]) => this.schedule = data);
        } else if (!this.selectedTeam && this.selectedWeek) {
            this.http.getScheduleByWeek(this.selectedWeek).subscribe((data: Match[]) => this.schedule = data);
        } else {
            this.http.getScheduleByTeamAndWeek(this.selectedTeam, this.selectedWeek)
                .subscribe((data: Match[]) => this.schedule = data);
        }
    }
}
