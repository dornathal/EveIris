package de.dornathal.eve.live.map;

public enum OperationActivity {

	None(0), Agriculture(1), Construction(2), Mining(3),
	Chemical(4), Military(5), BioTech(6), HiTech(7),
	Entertainment(8), Shipyard(9), Warehouse(10), Retail(11),
	Trading(12), Bureaucratic(13), Political(14), Legal(15),
	Security(16), Financial(17), Educational(18), Manufacture(19),
	Disputed(20);
	private int value;

	OperationActivity(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
