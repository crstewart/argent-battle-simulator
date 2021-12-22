import {ChangeDetectorRef, Component} from "@angular/core";
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
    styleUrls: ['./character-details.component.css']
})
export class CharacterDetailsComponent extends ComplexHttpComponent {

    fighters: string[];

    selectedFighter: Fighter;

    constructor(private http: HttpService,
                private router: Router,
                private route: ActivatedRoute,
                private title: Title,
                private location: Location,
                private detector: ChangeDetectorRef) {
        super(http, router, route, title);
        combineLatest([this.route.params,
            this.route.data,
            this.http.getFighters()
        ])
            .pipe(map(([params, data, fighters]) =>
                ({params: params, data: data, fighters: fighters})))
            .subscribe(({params, data, fighters}) => {
                this.fighters = fighters;
                if (params.name && this.fighters && this.fighters.includes(params.name)) {
                    this.setFighter(params.name);
                    this.title.setTitle((data.title as string).replace(':name', params.name));
                } else {
                    this.location.replaceState('/fighters');
                }

                this.detector.detectChanges();
            });
    }

    setFighter(event: Event): void {
        let fighterName = ""+event;
        this.http.getFighter(fighterName).subscribe((data: Fighter) => {
            this.selectedFighter = data;
            this.location.replaceState(`/fighters/${fighterName}`);
            this.detector.detectChanges();
        });
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
