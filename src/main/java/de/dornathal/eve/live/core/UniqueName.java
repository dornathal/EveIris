package de.dornathal.eve.live.core;

import de.dornathal.eve.live.database.InvUniqueNames;
import de.dornathal.eve.live.product.Group;

import javax.persistence.*;

@Entity
@Table(name = InvUniqueNames.TABLE)
public class UniqueName {

	@Id
	@Column(name = InvUniqueNames.ITEM_ID)
	private int itemId;
	@Column(name = InvUniqueNames.ITEM_NAME)
	private String name;
	@OneToOne
	@JoinColumn(name = InvUniqueNames.GROUP_ID)
	private Group group;

	public int getItemId() {
		return itemId;
	}

	public String getName() {
		return name;
	}

	public Group getGroup() {
		return group;
	}
}
