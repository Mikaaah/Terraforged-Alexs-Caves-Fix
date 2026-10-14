# Terraforged Alex's Caves Fix

**Keep UltraTerraForged's landscapes. Bring Alex's Caves underground.**

Want UltraTerraForged's mountains, cliffs, and river valleys alongside Alex's Caves? This compatibility add-on helps the unofficial NeoForge port's cave biomes and native chambers generate correctly in UltraTerraForged worlds.

Built for **Minecraft 1.21.1 / NeoForge**, with targeted fixes for placement filters, chamber generation, additional carving, and biome location commands.

## What does it fix?

**Cave biome placement**
Adapts the port's original depth and inland/ocean filters to UltraTerraForged terrain. Rarity settings, disabled biomes, spawn exclusions, dimension restrictions, and deliberate custom ranges remain respected.

**Native cave chambers**
Stops UltraTerraForged's surface-structure river restriction from incorrectly rejecting Alex's underground chamber generators, while retaining their native placement and matching-biome checks.

**Protection from additional carving**
Prevents UltraTerraForged's additional carving, lining, and decorative block writes inside the six protected Alex's Caves biomes. Ordinary noise caves remain enabled.

**More useful biome locations**
In active UltraTerraForged worlds, `/locateacbiome` checks candidates against the actual biome source and provides an underground Y coordinate in its suggested teleport.

## Supported caves

- Magnetic Caves
- Primordial Caves
- Toxic Caves
- Abyssal Chasm
- Forlorn Hollows
- Candy Cavity

## Requirements

- **Minecraft 1.21.1**, **Java 21**, and **NeoForge 21.1.219 or newer within 21.1.x**
- **UltraTerraForged 1.0.2+1.21.1**
- **Alex's Caves unofficial NeoForge port 2.0.10**, by Raguto
- The **Citadel unofficial port** required by Alex's Caves; 2.7.6 was used in testing

Version 1.0.0 is pinned to the listed UltraTerraForged and Alex's Caves versions. Other TerraForged forks and Alex's Caves builds are not supported by this release.

## Installation

1. Install the required mods and their dependencies.
2. Add this fix to the **client and server** `mods` folders. For singleplayer, install it in your instance.
3. Select the **UltraTerraForged** world type and your preferred terrain preset.
4. Keep **Generate Structures enabled** for the native cave chambers.
5. Use a **new world or newly generated chunks**. Existing chunks are not repaired.

Back up an existing world before changing world-generation mods or settings. Run `/tfacfix status` with operator permissions to check that the fix is active.

## Configuration

Settings appear at `config/tfacfix-common.toml` after the first launch. Biome placement, chamber placement, carving protection, and locator verification can be enabled or disabled separately. Restart after changing world-generation settings.

The fix does not rewrite your Alex's Caves biome JSON files. Original default filters work with the automatic adaptation; deliberate custom ranges remain respected.

## What to expect

This mod fixes compatibility; it does **not** enlarge Alex's Caves chambers or install a terrain preset. A cave-biome location can contain solid rock between native chambers. The locator verifies the biome, not a safe teleport destination.

The profile activates only in an active UltraTerraForged Overworld. Carving protection follows the protected biome cells, not entire structure bounding boxes. Streams Reflowing compatibility is not included.

Dedicated-server checks passed for all six biome types, a representative Magnetic Caves chamber, locator commands, and carving protection, with TerraBlender 4.1.0.8 present. Client rendering, shaders, multiplayer client connections, and full modpacks have not been validated.

## Source and support

- [GitHub source](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix)
- [Report an issue](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/issues)
- [Validation details](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/blob/main/VALIDATION.md)

An independent compatibility add-on by **Towns & Kingdoms**. Not affiliated with or endorsed by the original mod teams. Credit to the UltraTerraForged team, the original Alex's Caves creators, and Raguto for the unofficial NeoForge port.

**License: GPL-3.0-only.** Modpack inclusion is welcome under the license terms.
