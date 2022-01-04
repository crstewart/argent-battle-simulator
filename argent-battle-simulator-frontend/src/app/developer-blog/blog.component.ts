import {Component, OnInit} from "@angular/core";
import {HttpService} from "../service/http.service";
import {ActivatedRoute, Router} from "@angular/router";
import {DomSanitizer, Title} from "@angular/platform-browser";
import {ComplexHttpComponent} from "../common/complex.http.component";
import {BlogEntry} from "../model/blog-entry";
import {combineLatest} from "rxjs";
import {map} from "rxjs/operators";

@Component({
    selector: 'developer-blog',
    templateUrl: './blog.component.html',
    styleUrls: ['./blog.component.css'],
    providers: [HttpService]
})
export class BlogComponent extends ComplexHttpComponent implements OnInit {

    entries: BlogEntry[];
    selected: number;

    constructor(private http: HttpService,
                private router: Router,
                private route: ActivatedRoute,
                private title: Title,
                private sanitizer: DomSanitizer) {
        super(http, router, route, title);
    }

    ngOnInit(): void {
        combineLatest([this.route.params,
            this.route.data,
            this.http.getBlogEntries()
        ])
            .pipe(map(([params, data, entries]) =>
                ({params: params, data: data, entries: entries})))
            .subscribe(({params, data, entries}) => {
                this.entries = entries;
                this.selected = +params.entry;
                if (this.selected) {
                    this.setEntry(this.selected);
                    this.title.setTitle((data.title as string).replace(':date',
                        this.getSelectedEntry().timestamp));
                } else {
                    this.title.setTitle((data.title as string));
                }
            });
    }

    getSelectedEntry(): BlogEntry {
        return this.entries[this.selected - 1];
    }

    private setEntry(entryNumber: number): void {
        if (this.selected < 1 || this.selected > this.entries.length) {
            this.navigate('/404');
        } else {
            this.http.getBlogEntryByNumber(entryNumber)
                .subscribe(html => this.getSelectedEntry().html = this.sanitizer.bypassSecurityTrustHtml(html));
        }
    }
}
