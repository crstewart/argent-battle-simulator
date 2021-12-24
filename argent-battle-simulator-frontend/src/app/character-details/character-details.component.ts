import {Component, OnInit} from "@angular/core";
import {HttpService} from "../service/http.service";
import {Fighter} from "../model/fighter";
import {ActivatedRoute, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";
import {ComplexHttpComponent} from "../common/complex.http.component";
import {combineLatest} from "rxjs";
import {map} from "rxjs/operators";
import {Location} from "@angular/common";

@Component({
    selector: 'character-details',
    templateUrl: './character-details.component.html',
    styleUrls: ['./character-details.component.css'],
    providers: [HttpService]
})
export class CharacterDetailsComponent extends ComplexHttpComponent implements OnInit {

    fighters: string[];

    selectedFighter?: string;
    displayedFighter: Fighter;

    constructor(private http: HttpService,
                private router: Router,
                private route: ActivatedRoute,
                private title: Title,
                private location: Location) {
        super(http, router, route, title);
        combineLatest([this.route.params,
            this.route.data,
            this.http.getFighters()
        ])
            .pipe(map(([params, data, fighters]) =>
                ({params: params, data: data, fighters: fighters})))
            .subscribe(({params, data, fighters}) => {
                this.fighters = fighters;
                let name = (params.name) ? CharacterDetailsComponent.getStandardName(params.name) : undefined;
                if (name && this.fighters && this.fighters.includes(name)) {
                    this.setFighter(name);
                    this.title.setTitle((data.title as string).replace(':name', name));
                } else {
                    this.title.setTitle((data.title as string));
                }
            });
    }

    ngOnInit(): void {
        if (this.selectedFighter) {
            this.location
                .replaceState(`/fighters/${CharacterDetailsComponent.getCanonicalName(this.selectedFighter)}`);
        } else {
            this.location.replaceState('/fighters');
        }
    }

    setFighter(name: string): void {
        this.http.getFighter(name).subscribe((fighter: Fighter) => {
            this.displayedFighter = fighter;
            this.selectedFighter = name;
            this.location.replaceState(`/fighters/${CharacterDetailsComponent.getCanonicalName(name)}`);
        });
    }

    prettyPrintValue(value: string): string {
        return value.trim().split(/[\s_]/g).map(word => this.prettyPrintWord(word)).join(" ");
    }

    prettyPrintValues(values: string[]): string {
        return values.map(value => this.prettyPrintValue(value)).join(", ");
    }

    prettyPrintWord(word: string): string {
        return word.charAt(0).toUpperCase() + word.substring(1).toLowerCase();
    }

    private static getCanonicalName(name: string): string {
        return name.trim().replace(/\s+/g, '_');
    }

    private static getStandardName(canonicalName: string): string {
        return canonicalName.trim().replace(/_/g, ' ');
    }
}
