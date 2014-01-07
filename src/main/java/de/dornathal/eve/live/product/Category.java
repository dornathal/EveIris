package de.dornathal.eve.live.product;

import de.dornathal.eve.live.Icon;
import de.dornathal.eve.live.database.InvCategories;

import javax.persistence.*;

@Entity
@Table(name = InvCategories.TABLE)
public class Category {
	@Id
	@Column(name = InvCategories.CATEGORY_ID)
	private int categoryId;
	@Column(name = InvCategories.DESCRIPTION)
	private String description;
	@Column(name = InvCategories.CATEGORY_NAME)
	private String name;
	//@Column(name = InvCategories.ICON_ID)
	@Transient //Todo Icon
	private Icon icon;
	@Column(name = InvCategories.PUBLISHED)
	private boolean published;

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Icon getIcon() {
		return icon;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public boolean isPublished() {
		return published;
	}
}
