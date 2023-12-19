package fr.insa.iss.DoorActuator.model;

public class DoorActuator {
	private boolean State = false;

	public boolean getState() {
		return State;
	}

	public void setState(boolean state) {
		State = state;
	}
}