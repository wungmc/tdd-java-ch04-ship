package com.wung.tddjava.ch04ship;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;


/**
 * TestNG 与 JUnit 不同之处：
 * 1. TestNG 的 @Test 可以加在类上，表示该类的所有方法都是测试；
 * 2. 测试类运行时，TestNG 使用同一个测试实例，而 JUnit 的每个测试都是不同的实例。
 *
 */
@Test
public class ShipSpec {
	
	private Location location;
	private Planet planet;
	private Ship ship;
	
	
	@BeforeMethod
	public void beforeMethod() {
		Direction direction = Direction.NORTH;
		location = new Location(new Point(21, 13), direction);
		planet = new Planet(new Point(50, 50), new ArrayList<>());
		ship = new Ship(location, planet);
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
		Assert.assertEquals(ship.getPlanet(), planet);
	}
	
	public void givenDirectionEastAndMaxXWhenReceiveCommandsFThenWrap() {
		location.setDirection(Direction.EAST);
		location.getPoint().setX(planet.getMax().getX());
		ship.receiveCommands("f");
		Assert.assertEquals(ship.getLocation().getX(), 1);
	}
	
	public void givenDirectionEastAndXEquals1WhenReceiveCommandsBThenWrap() {
		location.setDirection(Direction.EAST);
		location.getPoint().setX(1);
		ship.receiveCommands("b");
		Assert.assertEquals(ship.getLocation().getX(), ship.getPlanet().getMax().getX());
	}
	
	public void whenReceiveCommandsThenStopOnObstacle() {
		// 在军舰当前位置的右侧增加一个障碍物
		List<Point> objstacles = new ArrayList<>();
		objstacles.add(new Point(location.getX() + 1, location.getY()));
		planet.setObstacles(objstacles);
		
		Location expected = location.copy();
		expected.turnRight();
		// 这步注释掉，模拟有障碍物的情况
		// expected.forward(new Point(0, 0), new ArrayList<>());
		expected.turnLeft();
		expected.backward(new Point(0, 0), new ArrayList<>());
		
		ship.receiveCommands("rflb");
		Assert.assertEquals(ship.getLocation(), expected);
	}
	
	public void whenReceiveCommandsThenOForOKAndXForObstacle() {
		// 在军舰当前位置的右侧增加一个障碍物
		List<Point> objstacles = new ArrayList<>();
		objstacles.add(new Point(location.getX() + 1, location.getY()));
		planet.setObstacles(objstacles);
		
		String status = ship.receiveCommands("rflb");
		Assert.assertEquals(status, "OXOO");
	}
	
}
