# Validation — version 1.0.0

## Build and focused checks

- Built using JDK 21, NeoForge 21.1.219, ModDevGradle 2.0.148 and Gradle 9.2.1.
- Fourteen plain-Java profile/range checks passed. They cover high-terrain default depth adaptation, custom range preservation, surface rejection, inland/ocean handling, disabled adaptation and large negative-coordinate spawn exclusions.
- Mod metadata and mixin resource entries were parsed and checked.

## Dedicated-server integration

Runtime: Minecraft 1.21.1, NeoForge 21.1.219, UltraTerraForged 1.0.2+1.21.1, Alex's Caves unofficial port 2.0.10, Citadel unofficial port 2.7.6, TerraBlender 4.1.0.8. The test used the supplied GenOne preset, seed 918273645, and fresh chunks.

Passed checks are recorded in `validation/ultraterraforged-with-terrablender.json`:

- Active UltraTerraForged Overworld sampler bound correctly.
- All six Alex cave biomes found and verified through the actual biome source, with repeatable sample results.
- A generated Magnetic Caves chunk stored the expected biome.
- A native ferrocave chamber start was found near the sampled biome and its completed chunk's structure references were verified. A biome sample can be solid rock between native chamber structures, so chamber existence was checked at an actual chamber start rather than assumed at every biome sample.
- `/tfacfix status` and the intercepted `/locateacbiome primordial_caves` command executed successfully.
- The extra carving clear, direct set and lining paths preserved a tagged cave block; ordinary biome clear/set writes still worked.
- Nether and End samplers stayed unbound.

A separate fresh `minecraft:normal` control world with the same mods installed passed the inactive-Overworld binding and Nether/End checks. Results are in `validation/vanilla-control.json`.

The transformed biome-source method was inspected to confirm callback order: TFAC selection runs before the original Alex callback and TerraBlender. Rejected candidates continue through TerraBlender's positional selection, not a substituted point-only fallback.

The chamber hook retains the port's native candidate/piece generation and the matching biome check while avoiding UltraTerraForged's global surface-placement river rule for Alex's chamber generator classes only.

## Limits

These are dedicated-server checks. Client rendering, shaders, multiplayer client connections, the user's complete modpack, and the visual quality of every cave chamber were not tested. Only one representative chamber was generated and checked; all six biome types were sampled. Existing saved chunks are not repaired.

The isolated development environment required a Java-executable discovery fallback in the local NeoForm build tool. That environment-only tooling change is not part of this mod or its source project; the game/mod code was compiled normally against the NeoForge development artifacts.

## Binary

`terraforged-alexs-caves-fix-1.0.0-neoforge-1.21.1.jar`

SHA-256: `73ef7b112ae09710e243fb2d616102bd9891bddbd628086282c727fdf3fb3516`
