import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CharacterDetailsComponent} from "./character-details/character-details.component";
import {SimulatorComponent} from "./simulator/simulator.component";
import {SimulatorDetailsComponent} from "./simulator-details/simulator-details.component";
import {PatchNotesComponent} from "./patch-notes/patch-notes.component";
import {StandingsComponent} from "./standings/standings.component";

const routes: Routes = [
    { path: '', component: SimulatorComponent },
    { path: 'how-it-works', component: SimulatorDetailsComponent },
    { path: 'details', component: CharacterDetailsComponent },
    { path: 'patch-notes', component: PatchNotesComponent },
    { path: 'standings', component: StandingsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
