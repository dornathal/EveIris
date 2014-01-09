package de.dornathal.eve.live;

public class Icon {

	private final int iconId;
	private String directory;

	private String imageServer = "https://image.eveonline.com/";

	public Icon(final IconType iconType, int iconId) {
		this.directory = iconType + "/";
		this.iconId = iconId;
	}

	public String getIconFile(int width) {
		return imageServer + directory + iconId + "_" + width + ".png";
	}

	public int getIconId() {
		return iconId;
	}

	public void setImageServer(final String imageServer) {
		this.imageServer = imageServer;
	}

	public enum IconType {
		Alliance, Corporation, Character, Type, Render
	}
}
