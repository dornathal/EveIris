package de.dornathal.eve.live.product;

import de.dornathal.eve.live.database.RamTypeRequirements;
import de.dornathal.eve.live.production.Activity;

import javax.persistence.*;

@Entity
@Table(name = RamTypeRequirements.TABLE)
public class ActivityUsage {

	@Id
	@Column(name = RamTypeRequirements.TYPE_ID)
	private int activityUsageTypeId;
	@Enumerated
	@Column(name = RamTypeRequirements.ACTIVITY_ID, columnDefinition = "TINYINT")
	private Activity activity;
	@Column(name = RamTypeRequirements.DAMGE_PER_JOB)
	private double damagePerJob;
	@Column(name = RamTypeRequirements.RECYCLE)
	private boolean recycling;
	@Column(name = RamTypeRequirements.QUANTITY)
	private int quantity;
	@OneToOne
	@JoinColumn(name = RamTypeRequirements.REQUIRED_TYPE_ID)
	private ProductType requiredType;

	public Activity getActivity() {
		return activity;
	}

	public double getDamagePerJob() {
		return damagePerJob;
	}

	public boolean isRecycling() {
		return recycling;
	}

	public int getQuantity() {
		return quantity;
	}

	public ProductType getRequiredType() {
		return requiredType;
	}

	public int getActivityUsageTypeId() {
		return activityUsageTypeId;
	}
}
