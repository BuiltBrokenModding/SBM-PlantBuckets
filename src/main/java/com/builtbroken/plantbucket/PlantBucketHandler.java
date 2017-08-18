package com.builtbroken.plantbucket;

import com.builtbroken.mc.fluids.bucket.BucketMaterial;
import com.builtbroken.mc.fluids.bucket.BucketMaterialHandler;
import com.builtbroken.mc.fluids.mods.BucketHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;

/**
 * Handlers interaction for plant materials
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 8/18/2017.
 */
public class PlantBucketHandler extends BucketHandler
{
    public PlantBucketHandler()
    {
        super(PlantBucket.DOMAIN, "default");
    }

    //TODO add AI logic for animals to attempt to eat plant buckets
    @Override
    public boolean rightClickEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity)
    {
        //Ignore creative players for this event
        if (player.capabilities.isCreativeMode)
        {
            return false;
        }

        //Only function for plant materials
        BucketMaterial material = BucketMaterialHandler.getMaterial(stack.getItemDamage());
        if (material != null && material instanceof PlantBucketMaterial) //TODO add config per material
        {
            //If cow do chance check to eat bucket
            if (entity instanceof EntityCow && ((PlantBucketMaterial) material).allowCowToEatBucket && player.world.rand.nextFloat() < ((PlantBucketMaterial) material).eatChance)
            {
                //Info to player so no WTF moments
                player.sendMessage(new TextComponentTranslation("item.plantbucket:PlantBucket.eat.bucket.cow"));
                //Eat bucket
                player.inventory.decrStackSize(player.inventory.currentItem, 1);
                return true;
            }
        }
        return false;
    }
}
