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
		return location.forward(planet.getMax(), planet.getObstacles());
	}
	
	public boolean moveBackward() {
		return location.backward(planet.getMax(), planet.getObstacles());
	}
	
	public void turnLeft() {
		location.turnLeft();
	}
	
	public void turnRight() {
		location.turnRight();
	}
	
	public String receiveCommands(String commands) {
		StringBuilder result = new StringBuilder();
		commands.chars().forEach(command -> {
					boolean status = true;
					switch (command) {
						case 'f':
							status= moveForward();
							break;
						case 'b':
							status = moveBackward();
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
					if (status) {
						result.append("O");
					}
					else {
						result.append("X");
					}
				});
		
		return result.toString();

	}
	
}
