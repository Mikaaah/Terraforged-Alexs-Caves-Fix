import nl.townsandkingdoms.tfacfix.PlacementRules;

public class PlacementRulesTest {
    private static void check(boolean condition, String name) {
        if (!condition) throw new AssertionError(name);
    }
    public static void main(String[] args) {
        check(PlacementRules.matchesDepth(3.5f, new float[]{0.05f, 2f}, 8f), "High terrain default depth is adapted");
        check(!PlacementRules.matchesDepth(3.5f, new float[]{0.1f, 1.5f}, 8f), "Custom depth stays restrictive");
        check(!PlacementRules.matchesDepth(0f, new float[]{0.05f, 2f}, 8f), "Surface depth remains excluded");
        check(PlacementRules.matchesDepth(8f, new float[]{0.05f, 2f}, 8f), "Upper depth bound is inclusive");
        check(!PlacementRules.matchesDepth(8.1f, new float[]{0.05f, 2f}, 8f), "Upper depth bound remains bounded");
        check(PlacementRules.matchesContinentalness("primordial_caves", 0.1f, new float[]{0.4f, 1f}, false, true), "Actual inland terrain can host primordial caves");
        check(!PlacementRules.matchesContinentalness("primordial_caves", 0.8f, new float[]{0.4f, 1f}, true, true), "Original inland profile excludes oceans");
        check(!PlacementRules.matchesContinentalness("primordial_caves", 0.1f, new float[]{0.6f, 1f}, false, true), "Custom continentalness is preserved");
        check(PlacementRules.matchesContinentalness("abyssal_chasm", -0.3f, new float[]{-0.95f, -0.65f}, true, true), "Real ocean accepts adapted abyssal profile");
        check(!PlacementRules.matchesContinentalness("abyssal_chasm", -0.8f, new float[]{-0.95f, -0.65f}, false, true), "Abyssal original profile excludes land");
        check(!PlacementRules.matchesContinentalness("primordial_caves", 0.1f, new float[]{0.4f, 1f}, false, false), "Disabled adaptation restores original check");
        check(PlacementRules.outsideSpawnExclusion(-100_000, 100_000, 650), "Far negative coordinates do not overflow");
        check(!PlacementRules.outsideSpawnExclusion(10, -10, 450), "Spawn exclusion retained");
        check(PlacementRules.matches(0.5f, null), "Unspecified filters remain unrestricted");
        System.out.println("14 focused placement rule checks passed");
    }
}
