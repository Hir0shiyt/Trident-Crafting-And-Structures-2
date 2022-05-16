
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tridentcraftingstructurestwo.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.tridentcraftingstructurestwo.item.TridenttopItem;
import net.mcreator.tridentcraftingstructurestwo.item.TridentstickItem;
import net.mcreator.tridentcraftingstructurestwo.TridentCraftingStructuresTwoMod;

public class TridentCraftingStructuresTwoModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TridentCraftingStructuresTwoMod.MODID);
	public static final RegistryObject<Item> TRIDENTSTICK = REGISTRY.register("tridentstick", () -> new TridentstickItem());
	public static final RegistryObject<Item> TRIDENTTOP = REGISTRY.register("tridenttop", () -> new TridenttopItem());
}
