import {Component} from "@angular/core";
import "rxjs/Rx";

@Component({
    selector: 'app-base',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {

    scheduleUrl: string = "https://drive.google.com/open?id=1VHaNnRBGD7qIA9sHETvvkBT88_QdGUeEsDnUMGk7LlA";
    battleLogsUrl: string = "https://drive.google.com/open?id=1u8a1JMBoHlIbh-zL3bj34q58QjTsZ6rV";

    toggleMenu(isInternal: boolean) {
        if (AppComponent.hasTouch()) {
            let internalLinks = document.getElementById("internalLinks");
            let externalLinks = document.getElementById("externalLinks");
            if (isInternal) {
                AppComponent.toggleLinks(internalLinks, externalLinks);
            } else {
                AppComponent.toggleLinks(externalLinks, internalLinks);
            }

        }
    }

    private static toggleLinks(linksToToggle: HTMLElement, linkstoHide: HTMLElement) {
        linkstoHide.style.display = "none";
        if (linksToToggle.style.display === "block") {
            linksToToggle.style.display = "none";
        } else {
            linksToToggle.style.display = "block";
        }
    }

    setDropdownClass(): string {
        let classes: string = "dropdown";
        if (!AppComponent.hasTouch()) {
            classes += " hover-menu"
        }

        return classes;
    }

    private static hasTouch(): boolean {
        return 'ontouchstart' in document.documentElement
            || navigator.maxTouchPoints > 0
            || navigator.msMaxTouchPoints > 0;
    }
}
