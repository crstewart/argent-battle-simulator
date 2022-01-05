import {Component, OnInit} from "@angular/core";
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
export class PatchNotesComponent extends ComplexRoutingComponent implements OnInit {

    options: Option[] = [
        {number: '1.2.2'},
        {number: '1.2.1'},
        {number: '1.2', name: 'Myths and Monsters'},
        {number: '1.1.1'},
        {number: '1.1', name: 'Reign of Shadows'},
        {number: '1.0.4'},
        {number: '1.0.3'},
        {number: '1.0.2'},
        {number: '1.0.1'}
    ];

    selected: Option;

    constructor(private router: Router,
                private route: ActivatedRoute,
                private title: Title,
                private location: Location) {
        super(router, route, title);
        combineLatest([this.route.params,
            this.route.data
        ])
            .pipe(map(([params, data]) =>
                ({params: params, data: data})))
            .subscribe(({params, data}) => {
                if (params.version) {
                    let version: Option = this.options.find(option => option.number === params.version);
                    if (version) {
                        this.selected = version;
                        this.title.setTitle((data.title as string).replace(':version', version.number));
                    }
                } else {
                    this.selected = this.options[0];
                    this.title.setTitle((data.title as string));
                }
            });
    }

    ngOnInit(): void {
        if (this.selected) {
            this.location.replaceState(`/patch-notes/${this.selected.number}`);
        } else {
            this.location.replaceState(`/patch-notes`);
        }
    }

    getVersionLabel(option: Option) {
        let label = `Version ${option.number}`;
        if (option.name) {
            label += ` - ${option.name}`;
        }

        return label;
    }

    setVersion(option: Option) {
        this.selected = option;
        this.location.replaceState(`/patch-notes/${this.selected.number}`);
    }
}

interface Option {
    number: string,
    name?: string
}
