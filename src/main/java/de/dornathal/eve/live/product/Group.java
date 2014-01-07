package de.dornathal.eve.live.product;

import de.dornathal.eve.live.Icon;
import de.dornathal.eve.live.database.InvGroups;

import javax.persistence.*;

@Entity
@Table(name = InvGroups.TABLE)
public class Group {

	@Id
	@Column(name = InvGroups.GROUP_ID)
	private int groupId;
	@Column(name = InvGroups.ALLOW_MANUFACTURE)
	private boolean allowManufacture;
	@Column(name = InvGroups.ALLOW_RECYCLER)
	private boolean allowRecycle;
	@Column(name = InvGroups.ANCHORABLE)
	private boolean anchorable;
	@Column(name = InvGroups.ANCHORED)
	private boolean anchored;
	@Column(name = InvGroups.FITTABLE_NON_SINGLETON)
	private boolean fittableNonSingleton;
	@Column(name = InvGroups.USE_BASE_PRICE)
	private boolean useBasePrice;
	@Column(name = InvGroups.DESCRIPTION)
	private String description;
	@Column(name = InvGroups.GROUP_NAME)
	private String name;
	@Column(name = InvGroups.PUBLISHED)
	private boolean published;
	@OneToOne
	@JoinColumn(name = InvGroups.CATEGORY_ID)
	private Category category;
	//@Column(name = InvGroups.ICON_ID)
	@Transient //Todo Icon
	private Icon icon;

	public boolean allowsManufacture() {
		return allowManufacture;
	}

	public boolean allowsRecycle() {
		return allowRecycle;
	}

	public boolean isAnchorable() {
		return anchorable;
	}

	public boolean isAnchored() {
		return anchored;
	}

	public boolean isFittableNonSingleton() {
		return fittableNonSingleton;
	}

	public boolean usesBasePrice() {
		return useBasePrice;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public Icon getIcon() {
		return icon;
	}

	public int getGroupId() {
		return groupId;
	}

	public boolean isPublished() {
		return published;
	}
}
