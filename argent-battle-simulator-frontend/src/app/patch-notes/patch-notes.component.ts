import {ChangeDetectorRef, Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {Title} from "@angular/platform-browser";
import {ComplexRoutingComponent} from "../common/complex.routing.component";
import {combineLatest} from "rxjs";
import {map} from "rxjs/operators";
import {Location} from "@angular/common";

@Component({
    selector: 'patch-notes',
    templateUrl: './patch-notes.component.html',
    styleUrls: ['./patch-notes.component.css']
})
export class PatchNotesComponent extends ComplexRoutingComponent {

    options: {number: string, name?: string}[] = [
        {number: '1.2.1'},
        {number: '1.2', name: 'Myths and Monsters'},
        {number: '1.1.1'},
        {number: '1.1', name: 'Reign of Shadows'},
        {number: '1.0.4'},
        {number: '1.0.3'},
        {number: '1.0.2'},
        {number: '1.0.1'}
    ];

    selected: {number: string, name?: string};

    constructor(private router: Router,
                private route: ActivatedRoute,
                private title: Title,
                private location: Location,
                private detector: ChangeDetectorRef) {
        super(router, route, title);
        combineLatest([this.route.params,
            this.route.data
        ])
            .pipe(map(([params, data]) =>
                ({params: params, data: data})))
            .subscribe(({params, data}) => {
                if (params.version) {
                    let version = this.options.find(option => option.number === params.version);
                    if (version) {
                        this.selected = version;
                        this.title.setTitle((data.title as string).replace(':version', version.number));
                    } else {
                        this.location.replaceState(`/patch-notes`);
                    }
                } else {
                    this.selected = this.options[0];
                    this.location.replaceState(`/patch-notes/${this.selected.number}`);
                }

                this.detector.detectChanges();
            });
    }

    getVersionLabel(option: {number: string, name?: string}) {
        let label = `Version ${option.number}`;
        if (option.name) {
            label += ` - ${option.name}`;
        }

        return label;
    }

    setVersion(event: Event) {
        let versionNumber = ""+event;
        for (let option of this.options) {
            if (option.number === versionNumber) {
                this.selected = option;
                break;
            }
        }

        this.detector.detectChanges();
    }
}
