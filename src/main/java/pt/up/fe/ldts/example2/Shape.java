package pt.up.fe.ldts.example2;

public abstract class Shape {
    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    enum TYPE {RECTANGLE, CIRCLE}

    private TYPE type;
    protected double x;
    protected double y;

    
    

    public abstract double getArea() throws Exception;

    public abstract double getPerimeter() throws Exception;


    public abstract void draw(GraphicFramework graphics);
}
