package com.wung.tddjava.ch04ship;

import java.util.List;

/**
 * 地图（有边缘，即最大的X轴、Y轴）
 */
public class Planet {

    private final Point max;
    public Point getMax() {
        return max;
    }

    private List<Point> obstacles;
    public List<Point> getObstacles() {
        return obstacles;
    }
    public void setObstacles(List<Point> obstacles) {
        this.obstacles = obstacles;
    }

    public Planet(Point max) {
        this.max = max;
    }
    public Planet(Point max, List<Point> obstacles) {
        this.max = max;
        this.obstacles = obstacles;
    }

}
