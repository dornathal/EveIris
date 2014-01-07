package de.dornathal.eve.live.product;

import de.dornathal.eve.live.database.InvTypeMaterials;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = InvTypeMaterials.TABLE)
public class ProductMaterial {
	@EmbeddedId
	private ProductMaterialId embeddedId;

	@OneToOne
	@JoinColumn(name = InvTypeMaterials.TYPE_ID, updatable = false, insertable = false)
	private ProductType product;
	@OneToOne
	@JoinColumn(name = InvTypeMaterials.MATERIAL_TYPE_ID, updatable = false, insertable = false)
	private ProductType material;

	@Column(name = InvTypeMaterials.QUANTITY)
	private int quantity;


	public int getQuantity() {
		return quantity;
	}

	public ProductType getProduct() {
		return product;
	}

	public ProductType getMaterial() {
		return material;
	}


	@Embeddable
	public static class ProductMaterialId implements Serializable {
		private static final long serialVersionUID = 1L;
		@Column(name = InvTypeMaterials.TYPE_ID)
		private int productTypeId;
		@Column(name = InvTypeMaterials.MATERIAL_TYPE_ID)
		private int materialTypeId;

		public ProductMaterialId() {

		}

		public ProductMaterialId(final int schematicId, final int productTypeId) {
			this.productTypeId = schematicId;
			this.materialTypeId = productTypeId;
		}
	}

}
