package de.dornathal.eve.live.attributes;

import de.dornathal.eve.live.database.DgmTypeAttributes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = DgmTypeAttributes.TABLE)
public class AttributeValue {

	@EmbeddedId
	private AttributeValue.EmbeddedAttributeId id;

	@OneToOne
	@JoinColumn(name = DgmTypeAttributes.ATTRIBUTE_ID, insertable = false, updatable = false, columnDefinition = "SMALLINT")
	private AttributeType Attribute;
	@Column(name = DgmTypeAttributes.VALUE_INT)
	private Integer valueInt;
	@Column(name = DgmTypeAttributes.VALUE_FLOAT)
	private Double valueFloat;

	public Integer getValueInt() {
		return valueInt;
	}

	public Double getValueFloat() {
		return valueFloat;
	}

	public double getValue() {
		return (valueFloat == null) ? valueInt : valueFloat;
	}

	public AttributeType getAttribute() {
		return Attribute;
	}

	public EmbeddedAttributeId getAttributeValueId() {
		return id;
	}

	@Embeddable
	public static class EmbeddedAttributeId implements Serializable {
		@Column(name = DgmTypeAttributes.TYPE_ID)
		private int typeId;

		@Column(name = DgmTypeAttributes.ATTRIBUTE_ID, columnDefinition = "SMALLINT")
		private int attributeId;

		public EmbeddedAttributeId(final Integer typeId, final Integer attributeId) {
			this.typeId = typeId;
			this.attributeId = attributeId;
		}

		public int getAttributeId() {
			return attributeId;
		}

		public int getTypeId() {
			return typeId;
		}
	}
}
