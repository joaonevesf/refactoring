package pt.up.fe.ldts.example5;

public class TurtleEast extends TurtleState{
    public TurtleEast(Turtle turtle) {
        this.turtle = turtle;
    }
    @Override
    public void moveForward() {
        turtle.setColumn(turtle.getColumn()+1);
    }

    @Override
    public void rotateRight() {

    }

    @Override
    public void rotateLeft() {

    }
}
