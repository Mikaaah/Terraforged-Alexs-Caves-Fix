<p align="center"><img src="docs/assets/banner.png" alt="UltraTerraForged × Alex’s Caves" width="100%"></p>

<h1 align="center">UltraTerraForged × Alex’s Caves</h1>

<p align="center"><strong>Bring the six underground cave biomes and native chambers into UltraTerraForged terrain.</strong></p>

<p align="center"><a href="https://www.curseforge.com/minecraft/mc-mods/ultraterraforged-alexs-caves-fix">Downloads</a> · <a href="https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/wiki">Player guide</a> · <a href="https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/issues">Report an issue</a> · <a href="https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/blob/main/CHANGELOG.md">Changelog</a> · <a href="https://discord.gg/CRYk3uDPVt">Discord</a></p>

<p align="center"><img src="https://img.shields.io/badge/Minecraft-1.21.1-5b8731?style=flat-square" alt="Minecraft 1.21.1"> <img src="https://img.shields.io/badge/NeoForge-d77828?style=flat-square" alt="NeoForge"> <a href="https://mikaaah.github.io/TownsAndKingdoms/projects/"><img src="https://img.shields.io/badge/Towns_%26_Kingdoms-Modding_Hub-7f384a?style=flat-square" alt="Towns & Kingdoms Modding Hub"></a></p>

## What it adds

- Adapts cave-biome placement to UltraTerraForged terrain while preserving custom placement settings.
- Allows Alex's Caves' native underground chambers to pass UltraTerraForged's surface river-placement restriction.
- Protects the six Alex's Caves biomes from UltraTerraForged's additional carving and decorative writes.
- Checks `/locateacbiome` results against the active biome source and includes an underground Y coordinate.

Supports Magnetic Caves, Primordial Caves, Toxic Caves, Abyssal Chasm, Forlorn Hollows and Candy Cavity.

## Using Wildshape / TNKTerraForged?

The TNK terrain fork’s NeoForge 1.21.1 edition integrates this adapter. Use the integrated version or this standalone `tfacfix` JAR; remove the standalone JAR when using the integrated equivalent to avoid duplicate Mixins. See [the fork’s compatibility instructions](https://github.com/Mikaaah/Towns-and-Kingdoms-Wildshape#readme).

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

## Pull up a chair

Questions, builds, feedback, server news and the occasional wildly overambitious factory: join the **Towns & Kingdoms Modding Hub**.

[![Join the Towns & Kingdoms Discord](https://i.imgur.com/Ojgcccm.png)](https://discord.gg/CRYk3uDPVt)

**[Join Discord](https://discord.gg/CRYk3uDPVt)** · [Explore all projects](https://mikaaah.github.io/TownsAndKingdoms/projects/) · [CurseForge projects](https://www.curseforge.com/members/mikaaah/projects)
