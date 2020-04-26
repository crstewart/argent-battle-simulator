import {Component} from "@angular/core";
import "rxjs/Rx";

@Component({
    selector: 'app-base',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent {

    standingsUrl: string = "https://drive.google.com/open?id=18fGNF8XuUqKVPYH2ldcGT3Pg8BsnVL3J7_z4FIN44pM";
    rostersUrl: string = "https://drive.google.com/open?id=1QNitZGBBdI-X2WUlOJY1x168K2YuCX96lgNnMfw0hYQ";
    scheduleUrl: string = "https://drive.google.com/open?id=1VHaNnRBGD7qIA9sHETvvkBT88_QdGUeEsDnUMGk7LlA";
    battleLogsUrl: string = "https://drive.google.com/open?id=1u8a1JMBoHlIbh-zL3bj34q58QjTsZ6rV";

    toggleLinks(id: string) {
        if (window.innerWidth <= 640) {
            let links = document.getElementById(id);
            if (links.style.display === "block") {
                links.style.display = "none";
            } else {
                links.style.display = "block";
            }
        }
    }
}
