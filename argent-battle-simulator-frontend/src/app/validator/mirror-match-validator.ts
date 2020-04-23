import {FormControl} from "@angular/forms";

export function checkIfMirrorMatch(control: FormControl) {
    let fighter1select = control.parent?.get('fighter1');
    let fighter2select = control.parent?.get('fighter2');
    if (!fighter1select || !fighter2select) {
        return null;
    }

    let fighter1 = fighter1select.value;
    let fighter2 = fighter2select.value;
    if (!fighter1 || !fighter2) {
        return null;
    }

    if (fighter1 === fighter2) {
        return { mirrorMatch: true };
    }

    return null;
}
