# Configuration & Commands

## Commands and configuration

```mcfunction
/tfacfix status
/locateacbiome primordial_caves
/locateacbiome magnetic_caves
```

`/tfacfix status` requires operator permission and reports the active compatibility profile.

Settings are in `config/tfacfix-common.toml`. Biome placement, chamber placement, carving protection and locator verification can be toggled separately. Restart after changing world-generation settings.

## When changes take effect

Restart the game or server after adjusting world-generation or flow settings. For current grids, allow Streams Reflowing to prepare newly visited areas before judging observed behavior.

## Suggested checks

1. Ensure the current world uses UltraTerraForged rather than vanilla generation.
2. Run `/tfacfix status` as an operator.
3. Test `/locateacbiome primordial_caves` or `/locateacbiome magnetic_caves` in newly generated regions.
4. Use screenshots and exact coordinates when reporting a cave placement issue.

[← Wiki Home](Home.md)
