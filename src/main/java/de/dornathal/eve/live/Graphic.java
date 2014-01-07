package de.dornathal.eve.live;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Graphic {

	@Id
	private int graphicId;
	private String description;
	private String fileName;
	private boolean obsolete;

	public String getDescription() {
		return description;
	}

	public String getFileName() {
		return fileName;
	}

	public boolean isObsolete() {
		return obsolete;
	}

	public int getGraphicId() {
		return graphicId;
	}

}
