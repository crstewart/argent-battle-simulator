export interface Fighter {
    name: string;
    description: string;
    classifications: string[];

    // stats
    hp: number;
    sp: number;
    maxSp: number;
    strength: number;
    toughness: number;
    dexterity: number;
    aim: number;
    agility: number;
    speed: number;
    intellect: number;
    willpower: number;
    size: number;
    weight: number;

    // characteristics
    traits: string[];
    defenses: string[];
    strategy: string;

    // moveset
    attacks: Attack[];
    xstrike: Attack;
    guards: Guard[];
    heals: Guard[];
}

export interface Attack {
    name: string;
    description?: string;
    attackType: string;
    power: number;
    variance: number;
    speed: number;
    attackSubTypes: string[];
    characteristics: string[];
}

export interface Guard {
    name: string;
    description?: string;
}
