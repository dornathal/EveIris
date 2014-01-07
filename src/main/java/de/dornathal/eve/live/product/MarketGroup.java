package de.dornathal.eve.live.product;

import de.dornathal.eve.live.Icon;
import de.dornathal.eve.live.database.InvMarketGroups;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = InvMarketGroups.TABLE)
public class MarketGroup {

	@Id
	@Column(name = InvMarketGroups.MARKET_GROUP_ID)
	private int marketGroupId;
	@Column(name = InvMarketGroups.DESCRIPTION)
	private String description;
	@Column(name = InvMarketGroups.MARKET_GROUP_NAME)
	private String name;
	//@OneToOne
	//@JoinColumn(name = InvMarketGroups.ICON_ID)
	@Transient //Todo Icon
	private Icon icon;
	@Column(name = InvMarketGroups.HAS_TYPES)
	private boolean hasTypes;
	@ManyToOne
	@JoinColumn(name = InvMarketGroups.PARENT_GROUP_ID)
	private MarketGroup parentGroup;
	@OneToMany
	@JoinColumn(name = InvMarketGroups.PARENT_GROUP_ID)
	private Collection<MarketGroup> childGroups;
	@OneToMany(mappedBy = "marketGroup")
	private Collection<ProductType> products;


	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}

	public Icon getIcon() {
		return icon;
	}

	public boolean hasTypes() {
		return hasTypes;
	}

	public MarketGroup getParentGroup() {
		return parentGroup;
	}

	public int getMarketGroupId() {
		return marketGroupId;
	}

	public Collection<MarketGroup> getChildGroups() {
		return childGroups;
	}

	public Collection<ProductType> getProducts() {
		return products;
	}
}
