import {Component, OnInit} from "@angular/core";
import {HttpService} from "../service/http.service";
import {Fighter} from "../model/fighter";

@Component({
    selector: 'character-details',
    templateUrl: './character-details.component.html',
    styleUrls: ['./character-details.component.css']
})
export class CharacterDetailsComponent implements OnInit {

    fighters: string[];

    selectedFighter: Fighter;

    constructor(private httpService: HttpService) {}

    ngOnInit(): void {
        this.httpService.getFighters().subscribe((data: string[]) => this.fighters = data);
    }

    setFighter(event: Event): void {
        let fighterName = ""+event;
        this.httpService.getFighter(fighterName).subscribe((data: Fighter) => this.selectedFighter = data);
    }

    prettyPrintValue(value: string): string {
        return value.split(/ _/g).map(this.prettyPrintWord).join(" ");
    }

    prettyPrintValues(values: string[]): string {
        return values.map(this.prettyPrintValue).join(", ");
    }

    prettyPrintWord(word: string): string {
        return word.charAt(0).toUpperCase() + word.substring(1).toLowerCase();
    }
}
