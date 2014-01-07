package de.dornathal.eve.live.npc;

public enum NpcCorporationSize {
	Unknown('U'), Tiny('T'), Small('S'), Medium('M'), Large('L'), Huge('H');

	private char value;

	private NpcCorporationSize(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}

	public static NpcCorporationSize getSize(final char size) {
		for( NpcCorporationSize corpSize : NpcCorporationSize.values() ){
			if( corpSize.getValue() == size ) return corpSize;
		}
		return Unknown;
	}
}
