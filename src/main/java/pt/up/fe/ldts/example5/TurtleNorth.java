package pt.up.fe.ldts.example5;

public class TurtleNorth extends TurtleState{
    public TurtleNorth(Turtle turtle) {
        this.turtle = turtle;
    }
    @Override
    public void moveForward() {
        turtle.setColumn(turtle.getColumn()+1);
    }

    @Override
    public void rotateRight() {
        turtle.setDirection(new TurtleEast(turtle));
    }

    @Override
    public void rotateLeft() {
        turtle.setDirection(new TurtleWest(turtle));
    }
}
