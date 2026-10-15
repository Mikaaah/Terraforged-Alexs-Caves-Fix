# Terraforged Alex's Caves Fix

Compatibility between UltraTerraForged and the unofficial NeoForge port of Alex's Caves for Minecraft 1.21.1.

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

## Credits and license

By Towns & Kingdoms.

- [UltraTerraForged](https://github.com/Pandaismyname1/ultraterraforged) by Pandaismyname1 and contributors.
- [Alex's Caves NeoForge port](https://github.com/Raguto/AlexsCaves-1.21.1) by Raguto and contributors, based on the original Alex's Caves.

[GPL-3.0-only](LICENSE).
