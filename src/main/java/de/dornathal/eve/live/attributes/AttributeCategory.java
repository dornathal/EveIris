package de.dornathal.eve.live.attributes;

public enum AttributeCategory {

	None(0), Fitting(1), Shield(2), Armor(3), Structure(4), Capacitor(5), Targeting(6), Miscellaneous(7), RequiredSkills(8), OtherCategory(9), Drones(10), AI(12);
	private int value;

	private AttributeCategory(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
