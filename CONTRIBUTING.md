# Contributing to Terraforged Alex's Caves Fix

This is a focused compatibility addon for **UltraTerraForged** and the unofficial **Alex's Caves NeoForge port** on Minecraft 1.21.1.

## Reporting generation issues

Please provide:

- Exact Minecraft, NeoForge, UltraTerraForged, Alex's Caves and Citadel versions.
- World seed, terrain preset and whether the affected chunks are newly generated.
- Cave biome, approximate coordinates and the expected and actual behavior.
- Logs, screenshots and the output of `/tfacfix status` where possible.
- A reduced mod list or minimal reproduction if the issue may involve another world-generation mod.

Avoid publishing personal information or private server details in logs.

## Pull requests

- Keep fixes scoped to compatibility; avoid changing original cave dimensions or unrelated world generation.
- Check that fixes don't affect vanilla Overworld, Nether or End behavior.
- Document configuration or command changes in the README and CHANGELOG.
- Follow the Java 21 [build instructions](README.md#building). Original dependency JARs are not redistributed.
- Describe the worlds/presets actually tested and any remaining limitations.

Open an issue before large behavioral changes so the approach can be discussed.
