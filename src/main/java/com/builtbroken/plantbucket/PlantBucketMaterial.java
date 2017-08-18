package com.builtbroken.plantbucket;

import com.builtbroken.mc.fluids.bucket.BucketMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.config.Configuration;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/18/2017.
 */
public class PlantBucketMaterial extends BucketMaterial
{
    boolean allowCowToEatBucket = true;
    float eatChance = 0.5f;

    public PlantBucketMaterial(BucketTypes type)
    {
        super(PlantBucket.PREFIX + "PlantBucket." + type.name().toLowerCase(), new ResourceLocation(PlantBucket.DOMAIN, "items/bucket." + type.name().toLowerCase()));
        damageBucketWithHotFluid = true;
        burnEntityWithHotFluid = true;
        setHandler(new PlantBucketHandler());
    }


    @Override
    public void handleConfig(Configuration config)
    {
        super.handleConfig(config);
        allowCowToEatBucket = config.getBoolean("allowCowToEatBucket", getConfigCategory(), true, "Allows for a small chance that a cow will try to eat a bucket made from plants");
        eatChance = config.getFloat("CowToEatBucketChance", getConfigCategory(), eatChance, 0f, 1f, "Chance the cow will eat the bucket, lower is more rare");
    }

    @Override
    public BucketMaterial getDamagedBucket(ItemStack stack)
    {
        return null;
    }
}
