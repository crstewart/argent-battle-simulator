import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CharacterDetailsComponent} from "./character-details/character-details.component";
import {SimulatorComponent} from "./simulator/simulator.component";

const routes: Routes = [
    { path: '', component: SimulatorComponent },
    { path: 'details', component: CharacterDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
