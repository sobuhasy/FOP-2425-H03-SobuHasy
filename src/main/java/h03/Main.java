package h03;

import fopbot.World;
import h03.robots.HackingRobot;
import h03.robots.VersatileRobot;
import h03.robots.DoublePowerRobot;
import h03.robots.MovementType;

/**
 * Main entry point in executing the program.
 */
public class Main {
    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
        // Create a 5x5 world and make it visible
        World.setSize(5, 5);
        World.setVisible(true);

        // Create and test 2 HackingRobots
        HackingRobot hackingRobot1 = new HackingRobot(0, 0, true);
        System.out.println("Actual type: " + hackingRobot1.getType());
        System.out.println("Next type: " + hackingRobot1.getNextType());
        hackingRobot1.shuffle();
        System.out.println("Actual type after shuffle: " + hackingRobot1.getType());
        System.out.println("Next type after shuffle: " + hackingRobot1.getNextType());

        HackingRobot hackingRobot2 = new HackingRobot(1, 1, false);
        System.out.println("Actual type: " + hackingRobot2.getType());
        System.out.println("Next type: " + hackingRobot2.getNextType());
        hackingRobot2.shuffle();
        System.out.println("Actual type after shuffle: " + hackingRobot2.getType());
        System.out.println("Next type after shuffle: " + hackingRobot2.getNextType());

        // Create and test 2 VersatileRobots
        VersatileRobot versatileRobot1 = new VersatileRobot(2, 2, true, true);
        while (versatileRobot1.getType() != MovementType.DIAGONAL){
            versatileRobot1.shuffle();
        }
        System.out.println("VersatileRobot1 x-coordinates: " + versatileRobot1.getX() + ", y-coordinates: " + versatileRobot1.getY());

        VersatileRobot versatileRobot2 = new VersatileRobot(3, 3, false, true);
        while (versatileRobot1.getType() != MovementType.DIAGONAL){
            versatileRobot2.shuffle();
        }
        System.out.println("VersatileRobot2 x-coordinates: " + versatileRobot2.getX() + ", y-coordinates: " + versatileRobot2.getY());

        // Create and test 3 DoublePowerRobots
        DoublePowerRobot doublePowerRobot1 = new DoublePowerRobot(4, 4, true);
        DoublePowerRobot doublePowerRobot2 = new DoublePowerRobot(0, 1, false);
        DoublePowerRobot doublePowerRobot3 = new DoublePowerRobot(1, 0, true);

        testDoublePowerRobot(doublePowerRobot1);
        testDoublePowerRobot(doublePowerRobot2);
        testDoublePowerRobot(doublePowerRobot3);

        // Create robot challenge and find winner
        DoublePowerRobot[] robots = {doublePowerRobot1, doublePowerRobot2, doublePowerRobot3};
        RobotsChallenge challenge = new RobotsChallenge(0, 4, robots);
        DoublePowerRobot[] winners = challenge.findWinners();

        System.out.println("Winner:");
        for (DoublePowerRobot winner : winners){
            System.out.println(winner);
        }
    }

    private static void testDoublePowerRobot(DoublePowerRobot robot){
        int diagonal = 0;
        int overstep = 0;
        int teleport = 0;

        while (diagonal == 0 || overstep == 0 || teleport == 0){
            robot.shuffle();
            MovementType type = robot.getType();
            MovementType nextType = robot.getNextType();
            System.out.println("Actual type: " + type + ", next type: " + nextType);

            switch (type){
                case DIAGONAL:
                    diagonal++;
                    break;
                case OVERSTEP:
                    overstep++;
                    break;
                case TELEPORT:
                    teleport++;
                    break;
            }
        }
    }
}
