package oooooooo;

public abstract class Animal {

   // public String _color;
	private String _color;

    public Animal(String color)
    {
        _color = color;
    }

    abstract void speak();

    abstract void sleep();

    abstract void eat();

    public String getColor() {
        return _color;
    }
    
    public void setColor(String color) {
    	this._color = color;
    }
}

// Variabeln color borde bara finnas i Animal klassen