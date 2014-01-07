package de.dornathal.eve.live.production;

public enum Activity {

	None(0), Manufacturing(1), ResearchTechnology(2), ResearchTimeProductivity(3),
	ResearchMaterialProductivity(4), Copying(5), Duplicationg(6), ReverseEngineering(7),
	Invention(8);
	private int value;

	Activity(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
