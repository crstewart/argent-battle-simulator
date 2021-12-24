import {Fighter} from "./fighter";

export interface SimulationResult {
    fighter1: Fighter,
    fighter2: Fighter,
    id?: string
    winner?: string,
    message?: string
}
