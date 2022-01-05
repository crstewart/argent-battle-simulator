import {SafeHtml} from "@angular/platform-browser";

export interface BlogEntry {
    number: number,
    title: string,
    description?: string,
    html?: SafeHtml,
    timestamp?: string
}
