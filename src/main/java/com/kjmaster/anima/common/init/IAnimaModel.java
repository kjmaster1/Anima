package com.kjmaster.anima.common.init;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IAnimaModel {

    @SideOnly(Side.CLIENT)
    public void initModel();
}
