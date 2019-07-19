package com.wung.tddjava.ch04ship;

import org.testng.Assert;
import org.testng.annotations.*;


/**
 * TestNG 与 JUnit 不同之处：
 * 1. TestNG 的 @Test 可以加在类上，表示该类的所有方法都是测试；
 * 2. 测试类运行时，TestNG 使用同一个测试实例，而 JUnit 的每个测试都是不同的实例。
 *
 */
@Test
public class ShipSpec {
	
	private int x = 10;
	private int y = 20;
	private Location location;
	private Ship ship;
	
	
	@BeforeMethod
	public void beforeMethod() {
		Direction direction = Direction.NORTH;
		location = new Location(new Point(x, y), direction);
		ship = new Ship(location);
	}
	
	public void whenInstantiatedThenLocationIsSet() {
		Assert.assertEquals(ship.getLocation(), location);
	}
	
	public void whenShipMoveForwardThenForward() {
		Location expected = location.copy();
		expected.forward();
		ship.moveForward();
		Assert.assertEquals(ship.getLocation(), expected);
	}
	
	
	public void whenShipMoveBackwardThenBackware() {
		Location expected = location.copy();
		expected.backward();
		ship.moveBackward();
		Assert.assertEquals(ship.getLocation(), expected);
	}
	
	
	public void whenTurnLeftThenLeft() {
		Location expected = location.copy();
		expected.turnLeft();
		ship.turnLeft();
		Assert.assertEquals(ship.getLocation(), expected);
	}
	
	public void whenTurnRightThenRight() {
		Location expected = location.copy();
		expected.turnRight();
		ship.turnRight();
		Assert.assertEquals(ship.getLocation(), expected);
	}
	
	public void whenReceiveCommandsFThenForward() {
		Location expected = location.copy();
		expected.forward();
		ship.receiveCommands("f");
		Assert.assertEquals(ship.getLocation(), expected);
	}
	
	public void whenReceiveCommandsBThenBackward() {
		Location expected = location.copy();
		expected.backward();
		ship.receiveCommands("b");
		Assert.assertEquals(ship.getLocation(), expected);
	}
	
	public void whenReceiveCommandsLThenLeft() {
		Location expected = location.copy();
		expected.turnLeft();
		ship.receiveCommands("l");
		Assert.assertEquals(ship.getLocation(), expected);
	}
	
	public void whenReceiveCommandsRThenRight() {
		Location expected = location.copy();
		expected.turnRight();
		ship.receiveCommands("r");
		Assert.assertEquals(ship.getLocation(), expected);
	}
	
	public void whenReceiveCommandsThenAllAreExected() {
		Location expected = location.copy();
		expected.turnRight();
		expected.forward();
		expected.turnLeft();
		expected.backward();
		ship.receiveCommands("rflb");
		Assert.assertEquals(ship.getLocation(), expected);
	}
	
	public void whenInstantiatedThenPlanetIsStored() {
		Point max = new Point(50, 50);
		Planet planet = new Planet(max);
		ship = new Ship(location, planet);
		Assert.assertEquals(ship.getPlanet(), planet);
	}
	
	
}
