import {Component, Input} from '@angular/core';
import {Fighter} from "../../model/fighter";

@Component({
    selector: 'character-image',
    templateUrl: './character-image.component.html',
    styleUrls: ['./character-image.component.css']
})
export class CharacterImageComponent {

    @Input() fighter: Fighter;

    @Input() float: 'none' | 'left' | 'right' = 'none';

    constructor() {

    }

    getImgSrc(): string {
        return `v1/fighters/${this.fighter.name}/image`;
    }

}
