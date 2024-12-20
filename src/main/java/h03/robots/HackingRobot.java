package h03.robots;

import fopbot.Robot;
import java.util.Random;

/**
 * Class for the HackingRobot, which can move in different ways.
 */
public class HackingRobot extends Robot{
    private MovementType type;
    private MovementType[] robotTypes;

    /**
     * Constructor for the HackingRobot.
     * @param x       the x-coordinate of the robot
     * @param y       the y-coordinate of the robot
     * @param order   the order of the robotTypes array
     */
    public HackingRobot(int x, int y, boolean order){
        // it calls the constructor of the base class Robot
        super(x, y);

        // it initializes the robotTypes array with the values of the MovementType enum
        this.robotTypes = new MovementType[]{MovementType.TELEPORT, MovementType.OVERSTEP, MovementType.DIAGONAL};

        // it moves the elements of the array depending on the order parameter
        if (order){
            // if the order is true, it moves the elements of the array to the right
            MovementType last = robotTypes[robotTypes.length - 1];
            System.arraycopy(robotTypes, 0, robotTypes, 1, robotTypes.length - 1);
            robotTypes[0] = last;
        } else{
            // if the order is false, it moves the elements of the array to the left
            MovementType first = robotTypes[0];
            System.arraycopy(robotTypes, 1, robotTypes, 0, robotTypes.length - 1);
            robotTypes[robotTypes.length - 1] = first;
        }

        // it initializes the variable type at the index 0 of the robotTypes array
        this.type = robotTypes[0];
    }

    /**
     * Method to get the type of the robot
     * @return the type of the robot
     */
    public MovementType getType(){
        return this.type;
    }

    /**
     * Method to get the next type of the robot
     *
     * @return the next type of the robot
     */
    public MovementType getNextType(){
        // Find the index of type in robotTypes
        int currentIndex = -1;
        for (int i = 0; i < robotTypes.length; i++){
            if (robotTypes[i] == type){
                currentIndex = i;
                break;
            }
        }
        int nextIndex = (currentIndex + 1) % robotTypes.length;
        return robotTypes[nextIndex];
    }

    /**
     * Generate a random number between 0 and the limit
     * @param limit the limit of the random number
     * @return the random number
     */
    public int getRandom(int limit){
        Random random = new Random();
        return random.nextInt(limit);
    }

    /**
     * Change the type of the robot randomly for a given of iterations
     * @param itNr the number of iterations to change the type
     * @return true if the type has changed, false otherwise
     */
    public boolean shuffle(int itNr){
        MovementType originalType = this.type;
        for (int i = 0; i < itNr; i++){
            int randomIndex = getRandom(robotTypes.length);
            this.type = robotTypes[randomIndex];
        }
        return !this.type.equals(originalType);
    }

    /**
     * Change the type of the robot randomly until the type has changed
     */
    public void shuffle(){
        boolean changed = false;
        while (!changed){
            changed = shuffle(1);
        }
    }
}
