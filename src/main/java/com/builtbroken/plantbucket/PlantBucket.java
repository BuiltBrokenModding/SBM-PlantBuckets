package com.builtbroken.plantbucket;

import com.builtbroken.mc.fluids.api.reg.BucketMaterialRegistryEvent;
import com.builtbroken.mc.fluids.bucket.BucketMaterialHandler;
import net.minecraft.init.Blocks;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/18/2017.
 */
@Mod(modid = PlantBucket.DOMAIN, name = "Plant Buckets", version = "@MAJOR@.@MINOR@.@REVIS@.@BUILD@", dependencies = "after:vefluids")
@Mod.EventBusSubscriber(modid = PlantBucket.DOMAIN)
public class PlantBucket
{
    public static final String DOMAIN = "plantbucket";
    public static final String PREFIX = DOMAIN + ":";

    @SubscribeEvent
    public static void registerBucketMaterials(BucketMaterialRegistryEvent.Pre event)
    {
        for (BucketTypes type : BucketTypes.values())
        {
            type.material = new PlantBucketMaterial(type);
            BucketMaterialHandler.addMaterial(type.name().toLowerCase(), type.material, type.ordinal());
        }
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event)
    {
        //TODO add crafting recipes for milk bucket
        ResourceLocation location = new ResourceLocation(DOMAIN, "plantbucket");
        event.getRegistry().register(new ShapedOreRecipe(location, BucketTypes.GRASS.getBucket(),
                " s ",
                "wcw",
                " w ",
                'w', Blocks.TALLGRASS,
                's', "stickWood",
                'c', "dye").setRegistryName("bucket.plant.grass"));
    }
}
