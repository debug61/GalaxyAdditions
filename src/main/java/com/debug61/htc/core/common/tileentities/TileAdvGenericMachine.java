package com.debug61.galaxyadditions.core.common.tileentities;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.tileentity.TileEntity;

public abstract class TileAdvGenericMachine extends TileEntity implements ISidedInventory {

    private String tileName;

    public TileAdvGenericMachine(String tileName) {
        this.tileName = tileName;
    }


}
