package de.dornathal.eve.live.product;

import de.dornathal.eve.live.Graphic;
import de.dornathal.eve.live.Icon;
import de.dornathal.eve.live.Race;
import de.dornathal.eve.live.attributes.AttributeValue;
import de.dornathal.eve.live.database.InvTypes;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = InvTypes.TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
public class ProductType {
	@Id
	@Column(name = InvTypes.TYPE_ID)
	private int productTypeId;
	@Transient //Todo AttributeValue
	private List<AttributeValue> attributes;
	@Column(name = InvTypes.BASE_PRICE, columnDefinition = "DECIMAL")
	private double basePrice;
	@OneToOne(mappedBy = "product")
	private BlueprintType blueprint;
	@Column(name = InvTypes.CAPACITY)
	private double capacity;
	@Transient //Todo BlueprintType
	private ProductType correspondingBlueprint;
	@Column(name = InvTypes.DESCRIPTION)
	private String description;
	@Transient //Todo Graphic
	private Graphic graphic;
	@OneToOne
	@JoinColumn(name = InvTypes.GROUP_ID)
	private Group group;
	@Transient //Todo Icon
	private Icon icon;
	@OneToOne
	@JoinColumn(name = InvTypes.MARKET_GROUP_ID)
	private MarketGroup marketGroup;
	private double mass;
	@OneToMany(mappedBy = "embeddedId.productTypeId")
	private List<ProductMaterial> materials;
	//	@Enumerated
	//	@OneToOne
	//	@JoinTable(name= InvMetaTypes.TABLE)
	@Transient
	private MetaGroup metaGroup;
	@Transient
	//@JoinColumn(name=InvTypes.)
	private ProductType MetaParentType;
	@Column(name = InvTypes.TYPE_NAME)
	private String name;
	@Column(name = InvTypes.PORTION_SIZE)
	private int portionSize;
	@Column(name = InvTypes.PUBLISHED)
	private boolean published;
	@OneToOne
	@JoinColumn(name = InvTypes.RACE_ID)
	private Race race;
	@Column(name = InvTypes.VOLUME)
	private double volume;
	@Column(name = InvTypes.CHANCE_OF_DUPLICATING)
	private double chanceOfDuplicating;


	public List<AttributeValue> getAttributes() {
		return attributes;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public BlueprintType getBlueprint() {
		return blueprint;
	}

	public double getCapacity() {
		return capacity;
	}

	public ProductType getCorrespondingBlueprint() {
		return correspondingBlueprint;
	}

	public String getDescription() {
		return description;
	}

	public Graphic getGraphic() {
		return graphic;
	}

	public Group getGroup() {
		return group;
	}

	public Icon getIcon() {
		return icon;
	}

	public MarketGroup getMarketGroup() {
		return marketGroup;
	}

	public double getMass() {
		return mass;
	}

	public List<ProductMaterial> getMaterials() {
		return materials;
	}

	public MetaGroup getMetaGroup() {
		return metaGroup;
	}

	public ProductType getMetaParentType() {
		return MetaParentType;
	}

	public String getName() {
		return name;
	}

	public int getPortionSize() {
		return portionSize;
	}

	public boolean isPublished() {
		return published;
	}

	public Race getRace() {
		return race;
	}

	public double getVolume() {
		return volume;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public double getChanceOfDuplicating() {
		return chanceOfDuplicating;
	}
}
