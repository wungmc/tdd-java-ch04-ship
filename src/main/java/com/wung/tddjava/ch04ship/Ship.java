package com.wung.tddjava.ch04ship;

public class Ship {
	
	private Location location;
	private Planet planet;
	
	public Ship(Location location, Planet planet) {
		this.location = location;
		this.planet = planet;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public Planet getPlanet() {
		return planet;
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
		commands.chars()
				.forEach(command -> {
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
				});

	}
	
}
