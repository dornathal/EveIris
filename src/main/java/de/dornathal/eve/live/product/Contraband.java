package de.dornathal.eve.live.product;

import de.dornathal.eve.live.Faction;
import de.dornathal.eve.live.database.InvContrabandTypes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = InvContrabandTypes.TABLE)
public class Contraband {
	@EmbeddedId
	private EmbeddedContrabandId embeddedContrabandId;
	@Column(name = InvContrabandTypes.ATTACK_MIN_SEC)
	private double attackFromMinSecurity;
	@Column(name = InvContrabandTypes.CONFISCATE_MIN_SEC)
	private double ConfiscateFromMinSecurity;
	@OneToOne
	@JoinColumn(name = InvContrabandTypes.FACTION_ID, updatable = false, insertable = false)
	private Faction faction;
	@Column(name = InvContrabandTypes.FINE_BY_VALUE)
	private double fineByValue;
	@OneToOne
	@JoinColumn(name = InvContrabandTypes.TYPE_ID, updatable = false, insertable = false)
	private ProductType product;
	@Column(name = InvContrabandTypes.STANDING_LOSS)
	private double standingLoss;

	public double getAttackFromMinSecurity() {
		return attackFromMinSecurity;
	}

	public double getConfiscateFromMinSecurity() {
		return ConfiscateFromMinSecurity;
	}

	public Faction getFaction() {
		return faction;
	}

	public double getFineByValue() {
		return fineByValue;
	}

	public ProductType getProduct() {
		return product;
	}

	public double getStandingLoss() {
		return standingLoss;
	}

	public EmbeddedContrabandId getEmbeddedContrabandId() {
		return embeddedContrabandId;
	}

	@Embeddable
	public static class EmbeddedContrabandId implements Serializable {

		@Column(name = InvContrabandTypes.FACTION_ID)
		private Integer factionId;
		@Column(name = InvContrabandTypes.TYPE_ID)
		private Integer productTypeId;

		public EmbeddedContrabandId(final Integer factionId, final Integer productTypeId) {
			this.factionId = factionId;
			this.productTypeId = productTypeId;
		}

		public Integer getFactionId() {
			return factionId;
		}

		public Integer getProductTypeId() {
			return productTypeId;
		}
	}
}
