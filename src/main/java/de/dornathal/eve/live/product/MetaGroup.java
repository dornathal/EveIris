package de.dornathal.eve.live.product;

public enum MetaGroup {
	None(0), Tech1(1), Tech2(2), Storyline(3), Faction(4), Officer(5), Deadspace(6),
	Frigates(7), FrigatesElite(8), FrigatesCommander(9), Destroyer(10), Cruiser(11),
	CruiserElite(12), CruiserCommander(13), Tech3(14);
	final int value;

	MetaGroup(final int value) {this.value = value;}

	public int getValue() {return value;}
}
