package com.demo;

/**
 * 汽车类
 */
public class Car {

    /**
     * 宽 cm
     */
    private float width;

    /**
     * 长 cm
     */
    private float length;

    /**
     * 高 cm
     */
    private float height;

    /**
     * 重量 kg
     */
    private float weight;

    /**
     * 功率
     */
    private float power = 0;

    /**
     * 方向
     */
    private Direction direction =  Direction.forward;

    /**
     * 构造函数
     * @param length
     * @param width
     * @param height
     * @param weight
     */
    public Car(float length, float width, float height, float weight) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    /**
     * 设定功率
     * @param power
     */
    public void setPower(float power) {
        this.power = power;
    }

    public float getPower() {
        return power;
    }

    /**
     * 转向
     * @param direction
     * @return
     */
    public void turn(Direction direction) {
        this.direction = direction;
    }

    public float getHeight() {
        return height;
    }

    public float getLength() {
        return length;
    }

    public Direction getDirection() {
        return direction;
    }

    public float getWeight() {
        return weight;
    }

    public float getWidth() {
        return width;
    }
}
