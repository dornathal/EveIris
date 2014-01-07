package de.dornathal.eve.live.npc;

public enum AgentType {

	Unknown(0),
	None(1),
	Basic(2),
	Tutorial(3),
	Research(4),
	CONCORD(5),
	GenericStorylineMission(6),
	StorylineMission(7),
	EventMission(8),
	FactionalWarfareAgent(9),
	EpicArcAgent(10);
	final int value;

	AgentType(final int value) {this.value = value;}

	public int getValue() {
		return value;
	}
}
