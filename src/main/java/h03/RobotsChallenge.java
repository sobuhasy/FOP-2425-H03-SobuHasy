package h03;

import h03.robots.DoublePowerRobot;
import h03.robots.MovementType;
import java.util.List;
import java.util.ArrayList;

/**
 * Class for the RobotsChallenge, which can move in different ways.
 */
public class RobotsChallenge {
    private final int winThreshold = 2;
    private final int begin, goal;
    private final DoublePowerRobot[] robots;

    /**
     * Constructor for the Initialization of the RobotsChallenge
     * @param begin        the start position of the robot diagonal
     * @param goal         the goal position of the robot diagonal
     * @param robots        the array of robots
     */
    public RobotsChallenge(int begin, int goal, DoublePowerRobot[] robots){
        this.begin = begin / winThreshold;
        this.goal = goal;
        this.robots = robots;
    }

    /**
     * Method to calculate the steps for the diagonal movement
     * @return the number of steps for the diagonal movement
     */
    public int calculateStepsDiagonal(){
        return Math.abs(begin - goal);
    }

    /**
     * Method to calculate the steps for the overstep movement
     * @return the number of steps for the overstep movement
     */
    public int calculateStepsOverstep(){
        return Math.abs(begin - goal) + (Math.abs(begin - goal) % 2);
    }

    /**
     * Method to calculate the steps for the teleport movement
     * @return the number of steps for the teleport movement
     */
    public int calculateStepsTeleport(){
        return Math.abs(begin - goal) / 2 + (Math.abs(begin - goal) % 2) * 2;
    }

    /**
     * Method to calculate the steps for the different types of movement
     * @param type       the type of movement
     * @return           the number of steps for the movement
     */
    public int calculateSteps(MovementType type){
        return type == MovementType.DIAGONAL ? calculateStepsDiagonal() :
            type == MovementType.OVERSTEP ? calculateStepsOverstep():
                calculateStepsTeleport();
    }

    /**
     * Method to find the winners of the challenge
     * @return the array of the winners
     */
    public DoublePowerRobot[] findWinners(){
        List<DoublePowerRobot> winnersList = new ArrayList<>();

        for (DoublePowerRobot robot : robots){
            int stepsType1 = calculateSteps(robot.getDoublePowerTypes()[0]);
            int stepsType2 = calculateSteps(robot.getDoublePowerTypes()[1]);
            int minSteps = Math.min(stepsType1, stepsType2);

            if (minSteps <= winThreshold){
                winnersList.add(robot);
            }
        }
        DoublePowerRobot[] winners = new DoublePowerRobot[winnersList.size()];
        return winnersList.toArray(winners);
    }
}
