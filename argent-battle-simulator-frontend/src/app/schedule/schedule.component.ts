import {Component, OnInit} from "@angular/core";
import {HttpService} from "../service/http.service";
import {Match} from "../model/match";

@Component({
    selector: 'schedule',
    templateUrl: './schedule.component.html',
    styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

    teams: string[];
    weeks: number[];

    selectedTeam: string;
    selectedWeek: number;

    schedule: Match[];

    constructor(private httpService: HttpService) {
    }

    ngOnInit(): void {
        this.httpService.getTeams().subscribe((data: string[]) => this.teams = data.filter((team) => team !== ""));
        this.httpService.getWeeks().subscribe((data: number[]) => this.weeks = data);
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
            this.httpService.getScheduleByTeam(this.selectedTeam).subscribe((data: Match[]) => this.schedule = data);
        } else if (!this.selectedTeam && this.selectedWeek) {
            this.httpService.getScheduleByWeek(this.selectedWeek).subscribe((data: Match[]) => this.schedule = data);
        } else {
            this.httpService.getScheduleByTeamAndWeek(this.selectedTeam, this.selectedWeek)
                .subscribe((data: Match[]) => this.schedule = data);
        }
    }
}
