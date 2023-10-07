package btw.community.dynamiclight;

import btw.AddonHandler;
import btw.BTWAddon;
import net.fabricmc.dynamiclight.BTWLightSource;
import net.minecraft.src.Block;

public class CompassPositioningAddon extends BTWAddon {

    private DynamicLightAddon() {
        super("CompassPositioning", "1.0.0", "Ex");
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }

}
