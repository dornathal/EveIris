package de.dornathal.eve.live;

import de.dornathal.eve.live.database.ChrAttributes;

import javax.persistence.*;

@Entity
@Table(name = ChrAttributes.TABLE)
public class Attribute {

	@Id
	@Column(name = ChrAttributes.ATTRIBUTE_ID, columnDefinition = "TINYINT")
	private int attributeId;
	@Column(name = ChrAttributes.DESCRIPTION)
	private String description;
	@Column(name = ChrAttributes.ATTRIBUTE_NAME)
	private String name;
	//@JoinColumn(name = ChrAttributes.ICON_ID)
	@Transient //ToDo Icon
	private Icon icon;
	@Column(name = ChrAttributes.NOTES)
	private String notes;
	@Column(name = ChrAttributes.SHORT_DESCRIPTION)
	private String shortDescription;

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Icon getIcon() {
		return icon;
	}

	public String getNotes() {
		return notes;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public int getAttributeId() {
		return attributeId;
	}
}
