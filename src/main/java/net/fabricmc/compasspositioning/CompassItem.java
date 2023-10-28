package net.fabricmc.compasspositioning;

import net.minecraft.src.*;

public class CompassItem extends Item {
    private long time = 0;

    public CompassItem(int iItemID, int iMaxUses) {
        super(iItemID);

        maxStackSize = 1;
        setMaxDamage( iMaxUses );

        setCreativeTab(CreativeTabs.tabTools);
    }


    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {

        if(!world.isRemote) {

            if (world.getWorldTime() - time > 10) {

                performUseEffects(player);

                player.sendChatToPlayer(player.getEntityName() + ": " + MathHelper.floor_double(player.posX) +
                        ", " + MathHelper.floor_double(player.posY) + ", " + MathHelper.floor_double(player.posZ));

                stack.damageItem(1, player);

                time = world.getWorldTime();
            }
            else if(time > world.getWorldTime()) {
                time = world.getWorldTime();
            }
        }

        return stack;
    }

    protected void performUseEffects(EntityPlayer player)
    {
        player.playSound( "fire.ignite", 1.0F,
                Item.itemRand.nextFloat() * 0.4F + 0.8F );
    }
}
