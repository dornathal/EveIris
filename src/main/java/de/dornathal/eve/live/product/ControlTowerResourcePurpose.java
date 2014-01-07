package de.dornathal.eve.live.product;

public enum ControlTowerResourcePurpose {
	Unspecified(0), Online(1), Power(2), CPU(3), Reinforce(4);
	final int value;

	ControlTowerResourcePurpose(final int value) {this.value = value;}

	public int getValue() {
		return value;
	}

}
