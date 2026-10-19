<p align="center"><img src="docs/assets/banner.png" alt="UltraTerraForged × Alex’s Caves" width="100%"></p>

<h1 align="center">UltraTerraForged × Alex’s Caves</h1>

<p align="center"><a href="https://www.curseforge.com/minecraft/mc-mods/ultraterraforged-alexs-caves-fix">CurseForge</a> · <a href="https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/wiki">Wiki</a> · <a href="https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/issues">Report an issue</a> · <a href="https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/blob/main/CHANGELOG.md">Changelog</a></p>

<p align="center"><img alt="Minecraft 1.21.1" src="https://img.shields.io/badge/Minecraft-1.21.1-568736?style=flat-square"> <img alt="NeoForge" src="https://img.shields.io/badge/Loader-NeoForge-d77828?style=flat-square"></p>

Bring Alex’s Caves’ underground biomes and native chambers into UltraTerraForged worlds.

[Download 1.0.0](downloads/terraforged-alexs-caves-fix-1.0.0-neoforge-1.21.1.jar?raw=true)

## What it adds

- Adapts cave-biome placement to UltraTerraForged terrain while preserving custom placement settings.
- Allows Alex's Caves' native underground chambers to pass UltraTerraForged's surface river-placement restriction.
- Protects the six Alex's Caves biomes from UltraTerraForged's additional carving and decorative writes.
- Checks `/locateacbiome` results against the active biome source and includes an underground Y coordinate.

Supports Magnetic Caves, Primordial Caves, Toxic Caves, Abyssal Chasm, Forlorn Hollows and Candy Cavity.

## Requirements

| Component | Version |
| --- | --- |
| Minecraft | 1.21.1 |
| NeoForge | 21.1.219 or later within 21.1.x |
| Java | 21 |
| UltraTerraForged | 1.0.2+1.21.1 |
| Alex's Caves unofficial NeoForge port | 2.0.10 by Raguto |

Install the Citadel port required by Alex's Caves as well.

## Setup

Install the fix alongside the required mods on both client and server. Select the **UltraTerraForged** world type and keep **Generate Structures** enabled for native cave chambers.

Generation changes apply to new chunks. Existing chunks are not regenerated.

## Know before you install

The fix activates in UltraTerraForged Overworlds. Vanilla worlds, the Nether and the End keep their normal biome sampling.

Native chamber sizes are unchanged. The locator finds a cave biome, which may contain solid rock between chambers; it does not guarantee a safe teleport destination.

## Guides

[Features](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/wiki/Features-and-Behavior) · [Configuration](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/wiki/Configuration-and-Commands) · [Compatibility](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/wiki/Compatibility-and-Limitations) · [Troubleshooting](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/wiki/Troubleshooting)

## Credits and license

By Towns & Kingdoms.

- [UltraTerraForged](https://github.com/Pandaismyname1/ultraterraforged) by Pandaismyname1 and contributors.
- [Alex's Caves NeoForge port](https://github.com/Raguto/AlexsCaves-1.21.1) by Raguto and contributors, based on the original Alex's Caves.

[GPL-3.0-only](LICENSE).
