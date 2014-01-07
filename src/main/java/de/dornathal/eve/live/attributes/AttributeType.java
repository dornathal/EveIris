package de.dornathal.eve.live.attributes;

import de.dornathal.eve.live.Icon;
import de.dornathal.eve.live.Unit;
import de.dornathal.eve.live.database.DgmAttributeTypes;

import javax.persistence.*;

@Entity
@Table(name = DgmAttributeTypes.TABLE)
public class AttributeType {
	@Id
	@Column(name = DgmAttributeTypes.ATTRIBUTE_ID, columnDefinition = "SMALLINT")
	private int attributeTypeId;
	@Enumerated
	@Column(name = DgmAttributeTypes.CATEGORY_ID, columnDefinition = "TINYINT")
	private AttributeCategory category;
	@Column(name = DgmAttributeTypes.DEFAULT_VALUE)
	private double defaultValue;
	@Column(name = DgmAttributeTypes.ATTRIBUTE_NAME)
	private String name;
	@Column(name = DgmAttributeTypes.DESCRIPTION)
	private String description;
	@Column(name = DgmAttributeTypes.DISPLAY_NAME)
	private String displayName;
	@Transient
	//@JoinColumn(name=DgmAttributeTypes.ICON_ID)
	private Icon icon;
	@Column(name = DgmAttributeTypes.HIGH_IS_GOOD)
	private boolean isHighGood;
	@Column(name = DgmAttributeTypes.STACKABLE)
	private boolean isStackable;
	@Column(name = DgmAttributeTypes.PUBLISHED)
	private boolean published;
	@OneToOne
	@JoinColumn(name = DgmAttributeTypes.UNIT_ID)
	private Unit unit;

	public AttributeCategory getCategory() {
		return category;
	}

	public double getDefaultValue() {
		return defaultValue;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getDisplayName() {
		return displayName;
	}

	public Icon getIcon() {
		return icon;
	}

	public boolean isHighGood() {
		return isHighGood;
	}

	public boolean isStackable() {
		return isStackable;
	}

	public boolean isPublished() {
		return published;
	}

	public Unit getUnit() {
		return unit;
	}

	public int getAttributeTypeId() {
		return attributeTypeId;
	}

}
