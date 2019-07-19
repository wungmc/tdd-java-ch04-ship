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
		if (commands.charAt(0) == 'f') {
			moveForward();
		}
		else if (commands.charAt(0) == 'b') {
			moveBackward();
		}
		else if (commands.charAt(0) == 'l') {
			turnLeft();
		}
		else if (commands.charAt(0) == 'r') {
			turnRight();
		}
	}
	
}
