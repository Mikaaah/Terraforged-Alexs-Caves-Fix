# Troubleshooting

## The add-on does not activate

- Verify Minecraft **1.21.1**, compatible NeoForge **21.1.x**, **Java 21** and the exact dependency versions in [Getting Started](Getting-Started.md).
- Install the compatibility add-on alongside both required mods. Dedicated servers and clients need matching JARs.
- Make sure the world type is an **UltraTerraForged Overworld**.
- Run `/tfacfix status` as an operator and check configuration toggles.

## Caves are not generating

Enable **Generate Structures** for native cave chambers. Check **new chunks**: existing terrain is not retroactively regenerated. A successful cave-biome locator result doesn't guarantee an open cavern at that coordinate.

## Wrong cave shape or location

The fix preserves native chamber size and protects placement against selected UltraTerraForged restrictions. Terrain presets, custom settings or other cave-generation mods can change the result.

## Report a reproducible issue

Open a [bug report](https://github.com/Mikaaah/Terraforged-Alexs-Caves-Fix/issues/new?template=bug_report.yml) with:

- Exact versions of all required mods and the Java/NeoForge runtime.
- World seed, preset and whether the affected chunks are new or existing.
- Coordinates **including Y**, expected behavior, observed behavior and screenshots.
- Diagnostic command output and relevant configuration values.
- Logs with private server details, user tokens and personal information removed.

[← Wiki Home](Home.md)
