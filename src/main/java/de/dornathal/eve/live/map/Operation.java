package de.dornathal.eve.live.map;

import de.dornathal.eve.live.database.StaOperations;
import de.dornathal.eve.live.product.ProductType;

import javax.persistence.*;

@Entity
@Table(name = StaOperations.TABLE)
public class Operation {

	@Enumerated
	@Column(name = StaOperations.ACTIVITY_ID, columnDefinition = "TINYINT")
	private OperationActivity activity;
	@Id
	@Column(name = StaOperations.OPERATION_ID, columnDefinition = "TINYINT")
	private int operationId;
	@Column(name = StaOperations.OPERATION_NAME)
	private String name;
	@Column(name = StaOperations.DESCRIPTION)
	private String description;
	@Column(name = StaOperations.FRINGE, columnDefinition = "TINYINT")
	private int fringe;
	@Column(name = StaOperations.CORRIDOR, columnDefinition = "TINYINT")
	private int corridor;
	@Column(name = StaOperations.HUB, columnDefinition = "TINYINT")
	private int hub;
	@Column(name = StaOperations.BORDER, columnDefinition = "TINYINT")
	private int border;
	@Column(name = StaOperations.RATIO, columnDefinition = "TINYINT")
	private int ratio;
	@OneToOne
	@JoinColumn(name = StaOperations.CALDARI_STATION_TYPE_ID)
	private ProductType caldariStationType;
	@OneToOne
	@JoinColumn(name = StaOperations.MINMATAR_STATION_TYPE_ID)
	private ProductType minmatarStationType;
	@OneToOne
	@JoinColumn(name = StaOperations.AMARR_STATION_TYPE_ID)
	private ProductType amarrStationType;
	@OneToOne
	@JoinColumn(name = StaOperations.GALLENTE_STATION_TYPE_ID)
	private ProductType gallenteStationType;
	@OneToOne
	@JoinColumn(name = StaOperations.JOVE_STATION_TYPE_ID)
	private ProductType joveStationType;

	public OperationActivity getActivity() {
		return activity;
	}

	public int getOperationId() {
		return operationId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getRatio() {
		return ratio;
	}

	public ProductType getCaldariStationType() {
		return caldariStationType;
	}

	public ProductType getMinmatarStationType() {
		return minmatarStationType;
	}

	public ProductType getAmarrStationType() {
		return amarrStationType;
	}

	public ProductType getGallenteStationType() {
		return gallenteStationType;
	}

	public ProductType getJoveStationType() {
		return joveStationType;
	}

	public int getFringe() {
		return fringe;
	}

	public int getCorridor() {
		return corridor;
	}

	public int getHub() {
		return hub;
	}

	public int getBorder() {
		return border;
	}
}
