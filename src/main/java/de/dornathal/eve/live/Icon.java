package de.dornathal.eve.live;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Icon {
	@Id
	private int iconId;
	private String description;
	private String iconFile;

	public String getDescription() {
		return description;
	}

	public String getIconFile() {
		return iconFile;
	}

	public int getIconId() {
		return iconId;
	}

}
