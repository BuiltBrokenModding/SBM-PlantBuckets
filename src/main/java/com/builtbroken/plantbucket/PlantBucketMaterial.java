package com.builtbroken.plantbucket;

import com.builtbroken.mc.fluids.bucket.BucketMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/18/2017.
 */
public class PlantBucketMaterial extends BucketMaterial
{
    public PlantBucketMaterial(BucketTypes type)
    {
        super(PlantBucket.PREFIX + "PlantBucket." + type.name().toLowerCase(), new ResourceLocation(PlantBucket.DOMAIN, "items/bucket." + type.name().toLowerCase()));
        damageBucketWithHotFluid = true;
        burnEntityWithHotFluid = true;
    }

    @Override
    public BucketMaterial getDamagedBucket(ItemStack stack)
    {
        return null;
    }
}
