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
}
