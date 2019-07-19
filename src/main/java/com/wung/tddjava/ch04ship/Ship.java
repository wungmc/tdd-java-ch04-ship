package com.wung.tddjava.ch04ship;

public class Ship {
	
	private Location location;
	
	public Ship(Location location) {
		this.location = location;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public boolean moveForward() {
		return location.forward();
	}
	
	public boolean moveBackward() {
		return location.backward();
	}
	
	public void turnLeft() {
		location.turnLeft();
	}
	
	public void turnRight() {
		location.turnRight();
	}
	
	public void receiveCommands(String commands) {
		char command = commands.charAt(0);
		switch (command) {
			case 'f':
				moveForward();
				break;
			case 'b':
				moveBackward();
				break;
			case 'l':
				turnLeft();
				break;
			case 'r':
				turnRight();
				break;
			default:
				break;
		}

	}
	
}
