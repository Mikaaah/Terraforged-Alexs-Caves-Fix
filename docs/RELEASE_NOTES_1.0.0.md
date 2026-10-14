# Terraforged Alex's Caves Fix 1.0.0

Initial compatibility release for **Minecraft 1.21.1 / NeoForge**.

- Adapt the Alex's Caves port's original placement filters to UltraTerraForged terrain.
- Restore native underground cave chamber placement where the global surface-structure river rule would reject it.
- Protect tagged Alex's Caves biomes from UltraTerraForged's additional carving, lining, and decorative block writes.
- Verify `/locateacbiome` candidates against the biome source and include an underground Y coordinate.
- Add `/tfacfix status` and independently configurable fix toggles.

Requires **UltraTerraForged 1.0.2+1.21.1**, **Raguto's Alex's Caves port 2.0.10** and its Citadel dependency, **NeoForge 21.1.219 or newer within 21.1.x**, and **Java 21**.

Install on the client and server. Use a new UltraTerraForged world or new chunks, with **Generate Structures enabled**. Existing chunks are not regenerated.

Dedicated-server checks passed with Citadel 2.7.6 and TerraBlender 4.1.0.8. All six biome types were sampled, and one representative native chamber was checked. Client rendering, shaders, multiplayer client connections, and complete modpacks have not been validated. This initial public build is suitable for further testing before use in an established world.

Native chamber sizes are unchanged. Streams Reflowing integration is not included.

SHA-256: `73ef7b112ae09710e243fb2d616102bd9891bddbd628086282c727fdf3fb3516`
