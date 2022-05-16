
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tridentcraftingstructurestwo.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;

import net.mcreator.tridentcraftingstructurestwo.world.features.SecretguardiantempleFeature;
import net.mcreator.tridentcraftingstructurestwo.world.features.LostseatempleFeature;
import net.mcreator.tridentcraftingstructurestwo.world.features.ForgottentimesanctuaryFeature;
import net.mcreator.tridentcraftingstructurestwo.world.features.FirstandlastlegendarytempleFeature;
import net.mcreator.tridentcraftingstructurestwo.TridentCraftingStructuresTwoMod;

import java.util.function.Supplier;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class TridentCraftingStructuresTwoModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES,
			TridentCraftingStructuresTwoMod.MODID);
	private static final List<FeatureRegistration> FEATURE_REGISTRATIONS = new ArrayList<>();
	public static final RegistryObject<Feature<?>> LOSTSEATEMPLE = register("lostseatemple", LostseatempleFeature::feature, new FeatureRegistration(
			GenerationStep.Decoration.SURFACE_STRUCTURES, LostseatempleFeature.GENERATE_BIOMES, LostseatempleFeature::placedFeature));
	public static final RegistryObject<Feature<?>> FIRSTANDLASTLEGENDARYTEMPLE = register("firstandlastlegendarytemple",
			FirstandlastlegendarytempleFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES,
					FirstandlastlegendarytempleFeature.GENERATE_BIOMES, FirstandlastlegendarytempleFeature::placedFeature));
	public static final RegistryObject<Feature<?>> SECRETGUARDIANTEMPLE = register("secretguardiantemple", SecretguardiantempleFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, SecretguardiantempleFeature.GENERATE_BIOMES,
					SecretguardiantempleFeature::placedFeature));
	public static final RegistryObject<Feature<?>> FORGOTTENTIMESANCTUARY = register("forgottentimesanctuary", ForgottentimesanctuaryFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, ForgottentimesanctuaryFeature.GENERATE_BIOMES,
					ForgottentimesanctuaryFeature::placedFeature));

	private static RegistryObject<Feature<?>> register(String registryname, Supplier<Feature<?>> feature, FeatureRegistration featureRegistration) {
		FEATURE_REGISTRATIONS.add(featureRegistration);
		return REGISTRY.register(registryname, feature);
	}

	@SubscribeEvent
	public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
		for (FeatureRegistration registration : FEATURE_REGISTRATIONS) {
			if (registration.biomes() == null || registration.biomes().contains(event.getName()))
				event.getGeneration().getFeatures(registration.stage()).add(registration.placedFeature().get());
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			Supplier<Holder<PlacedFeature>> placedFeature) {
	}
}
