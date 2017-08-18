package com.builtbroken.plantbucket;

import com.builtbroken.mc.fluids.FluidModule;
import com.builtbroken.mc.fluids.bucket.BucketMaterial;
import net.minecraft.item.ItemStack;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/18/2017.
 */
public enum BucketTypes
{
    GRASS;

    public BucketMaterial material;

    public ItemStack getBucket()
    {
        return new ItemStack(FluidModule.bucket, 1, material.metaValue);
    }
}