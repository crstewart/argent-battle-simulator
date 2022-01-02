import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SimulatorComponent} from "./simulator/simulator.component";
import {MissingPageComponent} from "./missing-page/missing-page.component";

const routes: Routes = [
    {
        path: 'home',
        component: SimulatorComponent,
        data: {title: 'Argent Battle Simulator'}
    },
    {
        path: 'how-it-works',
        loadChildren: () => import('./simulator-details/simulator-details.module').then(m => m.SimulatorDetailsModule)
    },
    {
        path: 'dev-blog',
        loadChildren: () => import('./developer-blog/blog.module').then(m => m.BlogModule)
    },
    {
        path: 'fighters',
        loadChildren: () => import('./character-details/character-details.module').then(m => m.CharacterDetailsModule)
    },
    {
        path: 'patch-notes',
        loadChildren: () => import('./patch-notes/patch-notes.module').then(m => m.PatchNotesModule)
    },
    {
        path: 'contribute',
        loadChildren: () => import('./contribute/contribute.module').then(m => m.ContributeModule)
    },
    {
        path: 'standings',
        loadChildren: () => import('./standings/standings.module').then(m => m.StandingsModule)
    },
    {
        path: 'rosters',
        loadChildren: () => import('./rosters/rosters.module').then(m => m.RostersModule)
    },
    {
        path: 'schedule',
        loadChildren: () => import('./schedule/schedule.module').then(m => m.ScheduleModule)
    },
    {
        path: 'battle-logs',
        loadChildren: () => import('./battle-logs/battle-logs.module').then(m => m.BattleLogsModule)
    },
    {
        path: 'season-one',
        loadChildren: () => import('./season-one/season-one.module').then(m => m.SeasonOneModule)
    },
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
    {
        path: 'developer-blog',
        redirectTo: '/dev-blog',
        pathMatch: 'full'
    },
    {
        path: 'details',
        redirectTo: '/fighters',
        pathMatch: 'full'
    },
    {
        path: 'characters',
        redirectTo: '/fighters',
        pathMatch: 'full'
    },
    {
        path: '**',
        component: MissingPageComponent,
        data: {title: 'Argent Battle Simulator - 404\'d!'}
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
