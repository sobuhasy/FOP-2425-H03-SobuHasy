package h03.robots;

/**
 * Class for the VersatileRobot, which can move in different ways.
 */
public class VersatileRobot extends HackingRobot{
    /**
     * Constructor for the initialization of the VersatileRobot
     * @param x             the x-coordinate of the robot
     * @param y             the y-coordinate of the robot
     * @param order         the order of the robotTypes array
     * @param exchange      if the x and y coordinates should be exchanged
     */
    public VersatileRobot(int x, int y, boolean order, boolean exchange){
        super(x, y, order);

        if (exchange){
            int temp = x;
            setX(y);
            setY(temp);
        }

        if (getType() == MovementType.DIAGONAL){
            setY(getX());
        }
    }

    @Override
    public boolean shuffle(int itNr){
        boolean changed = super.shuffle(itNr);

        if(getType() == MovementType.DIAGONAL){
            setY(getX());
        }
        return changed;
    }

    @Override
    public void shuffle(){
        super.shuffle();
        if(getType() == MovementType.DIAGONAL){
            setY(getX());
        }
    }
}
