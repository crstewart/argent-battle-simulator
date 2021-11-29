import {ChangeDetectorRef, Component} from "@angular/core";

@Component({
    selector: 'patch-notes',
    templateUrl: './patch-notes.component.html',
    styleUrls: ['./patch-notes.component.css']
})
export class PatchNotesComponent {

    options: string[] = [
        "1.2 - Myths and Monsters",
        "1.1.1",
        "1.1 - Reign of Shadows",
        "1.0.4",
        "1.0.3",
        "1.0.2",
        "1.0.1"
    ];

    selected: string = this.options[0];

    constructor(private detector: ChangeDetectorRef) {}

    setVersion(event: Event) {
        this.selected = ""+event;
        this.detector.detectChanges();
    }
}
