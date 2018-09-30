package pers.leetcode.solutions;

import java.util.HashSet;

/**
 * Created by bopang on 18/8/14.
 */
public class WalkingRobotSimulation {

    /* Notes:
    1) A more elegant to way to deal with changing direction:
       Turn right: update direction: (x, y) <- (y, -x)
       Turn left:  update direction: (x, y) <- (-y, x)
       although it's easier to make mistakes this way.
    2) A HashSet of integer pairs can be implemented by the following ways:
       a) element = x * base + y, where 1 <= x < base, and 1 <= y < base;
       b) element = Integer.toString(x) + " " + Integer.toString(y);
     */

    private void changeDirection(int[] direction, int command) {
        int tmp = direction[0];
        if (command == -2) { // turn left
            direction[0] = -direction[1];
            direction[1] = tmp;
        }
        else if(command == -1) { // turn right
            direction[0] = direction[1];
            direction[1] = -tmp;
        }
    }

    public int robotSim(int[] commands, int[][] obstacles) {

        int[] pos = new int[]{0, 0};
        int[] direction = new int[]{0, 1}; // Face north
        int maxSqr = 0;

        HashSet<Integer> obstacleSet = new HashSet<Integer>();
        int MAX_SIZE = 30000;
        int BASE = 2 * MAX_SIZE + 1;
        for (int ind = 0; ind < obstacles.length; ind ++) {
            obstacleSet.add( (obstacles[ind][0] + MAX_SIZE) * BASE + (obstacles[ind][1] + MAX_SIZE));
        }

        for(int ind = 0; ind < commands.length; ind ++) {
            if (commands[ind] < 0)
                changeDirection(direction, commands[ind]);
            else {
                for(int step = 0; step < commands[ind]; step ++) {
                    if (!obstacleSet.contains( (pos[0] + direction[0] + MAX_SIZE) * BASE +
                            (pos[1] + direction[1] + MAX_SIZE))) {
                        pos[0] += direction[0];
                        pos[1] += direction[1];
                        maxSqr = Math.max(maxSqr, (pos[0] * pos[0] + pos[1] * pos[1]));
                    }
                    else
                        break;
                }
            }
        }
        return maxSqr;
    }
}
