package de.dornathal.eve.live.planetary;

import de.dornathal.eve.live.database.PlanetSchematicsTypeMap;
import de.dornathal.eve.live.product.ProductType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = PlanetSchematicsTypeMap.TABLE)
public class ResourceSet {
	@EmbeddedId
	private ResourceSetId embeddedId;
	@Column(name = PlanetSchematicsTypeMap.QUANTITY, columnDefinition = "SMALLINT")
	private int quantity;
	@Column(name = PlanetSchematicsTypeMap.IS_INPUT)
	private boolean isInput;
	@OneToOne
	@JoinColumn(name = PlanetSchematicsTypeMap.TYPE_ID, updatable = false, insertable = false)
	private ProductType productType;

	public int getQuantity() {
		return quantity;
	}

	public ProductType getProductType() {
		return productType;
	}

	public int getSchematicId() {
		return embeddedId.schematicId;
	}

	public boolean isInput() {
		return isInput;
	}

	public static class ResourceSetId implements Serializable {
		private static final long serialVersionUID = 1L;
		@Column(name = PlanetSchematicsTypeMap.SCHEMATIC_ID, columnDefinition = "SMALLINT")
		private int schematicId;
		@Column(name = PlanetSchematicsTypeMap.TYPE_ID)
		private int productType;

		public ResourceSetId() {

		}

		public ResourceSetId(final int schematicId, final int productTypeId) {
			this.schematicId = schematicId;
			this.productType = productTypeId;
		}
	}
}
