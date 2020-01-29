package oooooooo;

import interfaces.IMotions;

public abstract class Animal implements IMotions {

    private String _color;
    private String _description;

    public Animal(String color, String description)
    {
        _color = color;
        _description = description;
    }

    public abstract void speak();

    public abstract void sleep();

    public abstract void eat();
    public String getColor() {
        return _color;
    }

    public void setColor(String color) {
        _color = color;
    }

    public void printDescritption() {
        System.out.println(_description);
    }

}