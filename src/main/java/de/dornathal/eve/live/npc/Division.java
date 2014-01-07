package de.dornathal.eve.live.npc;

public enum Division {
	Unknown(0), Accounting(1), Administration(2), Advisory(3), Archives(4),
	Astrosurveying(5), Command(6), DistributionDeprecated(7), Financial(8), Intelligence(9),
	InternalSecurity(10), Legal(11), Manufacturing(12), Marketing(13), MiningDeprecated(14),
	Personell(15), Production(16), PublicRelations(17), ResearchAndDevelopment(18),
	SecurityDeprecated(19), Storage(20), Surveillance(21), Distribution(22), Mining(23), Security(24),
	Business(25), Exploration(26), Industry(27), Military(28), AdvancedMilitary(29);
	final int value;

	Division(final int value) {this.value = value;}

	public int getValue() {
		return value;
	}

}
