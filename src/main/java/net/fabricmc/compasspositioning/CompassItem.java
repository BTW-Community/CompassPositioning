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

                player.sendChatToPlayer(player.getEntityName() + ": " + (int) player.posX +
                        ", " + (int) player.posY + ", " + (int) player.posZ);

                stack.damageItem(1, player);

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
