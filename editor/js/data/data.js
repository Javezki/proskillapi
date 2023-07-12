let DATA = {};

const version = (localStorage.getItem('server-version') || '1.20').substr(2);

depend('data/1.8', function() { if (version === '8') DATA = DATA_1_8 });
depend('data/1.9', function() { if (version === '9') DATA = DATA_1_9 });
depend('data/1.10', function() { if (version === '10') DATA = DATA_1_10 });
depend('data/1.11', function() { if (version === '11') DATA = DATA_1_11 });
depend('data/1.12', function() { if (version === '12') DATA = DATA_1_12 });
depend('data/1.13', function() { if (version === '13') DATA = DATA_1_13 });
depend('data/1.14', function() { if (version === '14') DATA = DATA_1_14 });
depend('data/1.15', function() { if (version === '15') DATA = DATA_1_15 });
depend('data/1.16', function() { if (version === '16') DATA = DATA_1_16 });
depend('data/1.17', function() { if (version === '17') DATA = DATA_1_17 });
depend('data/1.18', function() { if (version === '18') DATA = DATA_1_18 });
depend('data/1.19', function() { if (version === '19') DATA = DATA_1_19 });
depend('data/1.20', function() { if (version === '20') DATA = DATA_1_20 });

function getMaterials() {
    return DATA.MATERIALS;
}

function getDamageableMaterials() {
	return DATA.DAMAGEABLE_MATERIALS;
}

function getAnyMaterials() {
    return [ 'Any', ...DATA.MATERIALS ];
}

function getSounds() {
    return DATA.SOUNDS;
}

function getEntities() {
    return DATA.ENTITIES;
}

function getAnyEntities() {
    return [ 'Any', ...DATA.ENTITIES ];
}

function getParticles() {
    return DATA.PARTICLES || [];
}

function getBiomes() {
    return DATA.BIOMES;
}

function getDamageTypes() {
    return DATA.DAMAGE_TYPES;
}

function getPotionTypes() {
    return DATA.POTIONS;
}

function getAnyPotion() {
    return [ 'Any', ...DATA.POTIONS ];
}

function getGoodPotions() {
    const list = DATA.POTIONS.filter(type => GOOD_POTIONS.includes(type));
    return [ 'All', ...list ];
}

function getBadPotions() {
    const list = DATA.POTIONS.filter(type => BAD_POTIONS.includes(type));
    return [ 'All', ...list ];
}

function getDyes() {
    return DYES;
}

function getProjectiles() {
    return DATA.PROJECTILES;
}

function getAnyProjectiles() {
    return [ 'Any', ...DATA.PROJECTILES ];
}

function getMobDisguises() {
    return DATA.MOB_DISGUISES;
}

function getMiscDisguises() {
    return DATA.MISC_DISGUISES;
}

const GOOD_POTIONS = [
    "Speed",
    "Fast Digging",
    "Increase Damage",
    "Jump",
    "Regeneration",
    "Damage Resistance",
    "Fire Resistance",
    "Water Breathing",
    "Invisibility",
    "Night Vision",
    "Health Boost",
    "Absorption",
    "Saturation",
    "Glowing",
    "Luck",
    "Slow Falling",
    "Conduit Power",
    "Dolphins Grace"
];

const BAD_POTIONS = [
    "Slow",
    "Slow Digging",
    "Confusion",
    "Blindness",
    "Hunger",
    "Weakness",
    "Poison",
    "Wither",
    "Levitation",
    "Unluck"
];

const DYES = [
    'BLACK',
    'BLUE',
    'BROWN',
    'CYAN',
    'GRAY',
    'GREEN',
    'LIGHT_BLUE',
    'LIGHT_GRAY',
    'LIME',
    'MAGENTA',
    'ORANGE',
    'PINK',
    'PURPLE',
    'RED',
    'WHITE',
    'YELLOW'
];
