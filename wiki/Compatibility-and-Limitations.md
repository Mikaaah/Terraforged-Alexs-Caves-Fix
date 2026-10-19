# Compatibility & Limitations

## Compatibility

The fix activates in UltraTerraForged Overworlds. Vanilla worlds, the Nether and the End keep their normal biome sampling.

Native chamber sizes are unchanged. The locator finds a cave biome, which may contain solid rock between chambers; it does not guarantee a safe teleport destination.

## Tested dependency versions

See [Getting Started](Getting-Started) for the specific versions documented by this repository. Newer dependency versions are not automatically guaranteed to work.

## Bugs outside this add-on's scope

If a cave can be located but is enclosed by stone, that does not by itself mean the locator is broken. It identifies cave biome coordinates, not necessarily an open or safe chamber. This compatibility layer does not promise to repair all underground terrain or preserve arbitrary third-party cave modifications.

[← Wiki Home](Home)
