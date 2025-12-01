package com.debug61.galaxyadditions.core.common.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockAdvFruitPress extends BlockContainer {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BlockAdvFruitPress(String assetName) {
        super(ModBlocks.machine);
        setRegistryName("advfruitpress");
        setTranslationKey("advfruitpress");
        setHardness(3.0F);
        setHarvestLevel("pickaxe", 1);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    public Item getItemDropped(IBlockState state, Random random, int fortune) {
        return Item.getItemFromBlock(ModBlocks.advFruitPress);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.byHorizontalIndex(meta % 4);
        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }
}
