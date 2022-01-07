package got.client.gui;

import org.lwjgl.opengl.GL11;

import got.common.*;
import got.common.network.*;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.StatCollector;

public class GOTGuiOptions extends GOTGuiMenuWBBase {
	public GOTGuiButtonOptions buttonFriendlyFire;
	public GOTGuiButtonOptions buttonHiredDeathMessages;
	public GOTGuiButtonOptions buttonAlignment;
	public GOTGuiButtonOptions buttonMapLocation;
	public GOTGuiButtonOptions buttonConquest;

	@Override
	public void actionPerformed(GuiButton button) {
		if (button.enabled) {
			if (button instanceof GOTGuiButtonOptions) {
				GOTPacketSetOption packet = new GOTPacketSetOption(button.id);
				GOTPacketHandler.networkWrapper.sendToServer(packet);
			} else if (button.enabled && button == goBack) {
				mc.displayGuiScreen(new GOTGuiMenu());
			} else {
				super.actionPerformed(button);
			}
		}
	}

	@Override
	public void drawScreen(int i, int j, float f) {
		drawDefaultBackground();
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		String s = StatCollector.translateToLocal("got.gui.options.worldSettings");
		fontRendererObj.drawString(s, guiLeft + 100 - fontRendererObj.getStringWidth(s) / 2, guiTop + 10, 16777215);
		GOTPlayerData pd = GOTLevelData.getData(mc.thePlayer);
		buttonFriendlyFire.setState(pd.hasFriendlyFire());
		buttonHiredDeathMessages.setState(pd.hasEnableHiredDeathMessages());
		buttonAlignment.setState(!pd.hasHideAlignment());
		buttonMapLocation.setState(!pd.hasHideMapLocation());
		buttonConquest.setState(pd.hasEnableConquestKills());
		super.drawScreen(i, j, f);
		for (Object element : buttonList) {
			GuiButton button = (GuiButton) element;
			if (button instanceof GOTGuiButtonOptions) {
				((GOTGuiButtonOptions) button).drawTooltip(mc, i, j);
			}
		}
	}

	@Override
	public void initGui() {
		super.initGui();
		guiTop = (height - ySize) / 2 + 10;
		int buttonX = guiLeft + xSize / 2 - 100;
		int buttonY = guiTop + 40;
		buttonFriendlyFire = new GOTGuiButtonOptions(0, buttonX, buttonY, 200, 20, "got.gui.options.friendlyFire");
		buttonList.add(buttonFriendlyFire);
		buttonHiredDeathMessages = new GOTGuiButtonOptions(1, buttonX, buttonY + 24, 200, 20, "got.gui.options.hiredDeathMessages");
		buttonList.add(buttonHiredDeathMessages);
		buttonAlignment = new GOTGuiButtonOptions(2, buttonX, buttonY + 48, 200, 20, "got.gui.options.showAlignment");
		buttonList.add(buttonAlignment);
		buttonMapLocation = new GOTGuiButtonOptions(3, buttonX, buttonY + 72, 200, 20, "got.gui.options.showMapLocation");
		buttonList.add(buttonMapLocation);
		buttonConquest = new GOTGuiButtonOptions(5, buttonX, buttonY + 96, 200, 20, "got.gui.options.conquest");
		buttonList.add(buttonConquest);
		goBack = new GOTGuiButton(7, buttonX, buttonY + 120, 200, 20, StatCollector.translateToLocal("got.gui.menuButton"));
		buttonList.add(goBack);
	}
}
