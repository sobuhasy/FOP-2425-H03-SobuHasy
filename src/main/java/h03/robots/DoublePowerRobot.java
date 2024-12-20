package h03.robots;

import fopbot.Robot;

/**
 * Class for the DoublePowerRobot, which can move in different ways.
 */
public class DoublePowerRobot extends HackingRobot{
    private MovementType[] doublePowerTypes;
    /**
     * Constructor to initialize the DoublePowerRobot
     * @param x         the x-coordinate of the robot
     * @param y         the y-coordinate of the robot
     * @param order     the order of the robotTypes array
     */
    public DoublePowerRobot(int x, int y, boolean order){
        super(x, y, order);

        // initialization of doublePowerTypes
        doublePowerTypes = new MovementType[2];
        doublePowerTypes[0] = getType();
        doublePowerTypes[1] = getNextType();
    }

    @Override
    public boolean shuffle(int itNr){
        boolean changed = super.shuffle(itNr);
        doublePowerTypes[0] = getType();
        doublePowerTypes[1] = getNextType();
        return changed;
    }

    @Override
    public void shuffle(){
        super.shuffle();
        doublePowerTypes[0] = getType();
        doublePowerTypes[1] = getNextType();
    }

    /**
     * Method to get the double power types of the robot
     *
     * @return the array of the double power types
     */
    public MovementType[] getDoublePowerTypes(){
        return doublePowerTypes;
    }
}
