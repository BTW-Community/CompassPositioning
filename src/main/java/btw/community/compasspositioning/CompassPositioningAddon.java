package btw.community.compasspositioning;

import btw.AddonHandler;
import btw.BTWAddon;
import net.fabricmc.compasspositioning.CompassItem;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;

public class CompassPositioningAddon extends BTWAddon {

    private CompassPositioningAddon() {
        super("CompassPositioning", "1.0.0", "Ex");
    }

    @Override
    public void initialize() {

        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString()
                + " Initializing...");

        Item.itemsList[256 + 89] = (new CompassItem(89, 10))
                .setUnlocalizedName("compass").setCreativeTab(CreativeTabs.tabTools);
    }

}
