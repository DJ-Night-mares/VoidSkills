package com.djnightmares.voidskills.furnace;

import com.djnightmares.voidskills.Voidskills;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

public class BlockPoweredFurnace extends Block {

    public static final ResourceLocation POWERED_FURNACE = new ResourceLocation(Voidskills.MOD_ID, "powered_furnace");

    public BlockPoweredFurnace() {
        super(Material.IRON);
        //voidskills:furnace
        setRegistryName(POWERED_FURNACE);
        setTranslationKey(Voidskills.MOD_ID + ".powered_furnace");
        setHarvestLevel("pickaxe", 1);
        setCreativeTab(Voidskills.creativeTabs);

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(Objects.requireNonNull(getRegistryName()), "inventory"));
    }
}
