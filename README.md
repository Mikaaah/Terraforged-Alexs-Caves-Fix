# UltraTerraForged × Alex's Caves

[Project status](https://github.com/Mikaaah/Mikaaah/blob/master/STATUS.md) · [Report a bug](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/issues/new?template=bug_report.yml) · [Suggest a feature](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/issues/new?template=feature_request.yml) · [Questions](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/issues/new?template=question.yml) · [CurseForge download](https://www.curseforge.com/minecraft/mc-mods/ultraterraforged-alexs-caves-fix)

[![Minecraft 1.21.1](https://img.shields.io/badge/Minecraft-1.21.1-5B8731?style=flat-square)](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix)
[![NeoForge](https://img.shields.io/badge/Loader-NeoForge-D97724?style=flat-square)](https://neoforged.net/)
[![Version 1.0.0](https://img.shields.io/badge/Version-1.0.0-3F78A8?style=flat-square)](CHANGELOG.md)
[![GPL-3.0](https://img.shields.io/badge/License-GPL--3.0-64748B?style=flat-square)](LICENSE)

Compatibility between UltraTerraForged and the unofficial NeoForge port of Alex's Caves for Minecraft 1.21.1.

📚 **[Browse the documentation wiki](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/wiki/Home)** · [Installation](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/wiki/Getting-Started) · [Troubleshooting](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/wiki/Troubleshooting)

[Download 1.0.0](downloads/terraforged-alexs-caves-fix-1.0.0-neoforge-1.21.1.jar?raw=true) · [Changelog](CHANGELOG.md) · [Report an issue](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/issues)

## Features

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

## Installation

Install the fix alongside the required mods on both client and server. Select the **UltraTerraForged** world type and keep **Generate Structures** enabled for native cave chambers.

Generation changes apply to new chunks. Existing chunks are not regenerated.

## Commands and configuration

```mcfunction
/tfacfix status
/locateacbiome primordial_caves
/locateacbiome magnetic_caves
```

`/tfacfix status` requires operator permission and reports the active compatibility profile.

Settings are in `config/tfacfix-common.toml`. Biome placement, chamber placement, carving protection and locator verification can be toggled separately. Restart after changing world-generation settings.

## Compatibility

The fix activates in UltraTerraForged Overworlds. Vanilla worlds, the Nether and the End keep their normal biome sampling.

Native chamber sizes are unchanged. The locator finds a cave biome, which may contain solid rock between chambers; it does not guarantee a safe teleport destination.

## Building

Requires Java 21. Place these dependency files in `libs/`:

- `alexscaves-2.0.10.jar`
- `ultraterraforged-1.0.2+1.21.1-neoforge.jar`

Run `./gradlew build` on Linux/macOS or `gradlew.bat build` on Windows. Output is written to `build/libs/`. Dependency JARs are not included in this repository.


## Contributing

Found a bug or want to improve the project? Read the [contribution guide](CONTRIBUTING.md) for reporting details, testing expectations and pull requests.


## Credits and license

By Towns & Kingdoms.

- [UltraTerraForged](https://github.com/Pandaismyname1/ultraterraforged) by Pandaismyname1 and contributors.
- [Alex's Caves NeoForge port](https://github.com/Raguto/AlexsCaves-1.21.1) by Raguto and contributors, based on the original Alex's Caves.

[GPL-3.0-only](LICENSE).
