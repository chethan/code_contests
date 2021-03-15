package leetcode.graph;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/robot-room-cleaner/
public class RobotRoomCleaner {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        backtrack(robot,0,0,0,visited);
    }

    void backtrack(Robot robot,int row, int col,int direction, Set<String> visited){
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        visited.add(row+"_"+col);;
        robot.clean();
        for(int i=0;i<4;i++){
            int newDirection = (direction+i) % 4;
            int newRow = row + directions[newDirection][0];
            int newCol = col + directions[newDirection][1];

            if(!visited.contains(newRow+"_"+newCol) && robot.move()){
                backtrack(robot,newRow, newCol, newDirection,visited);
                goBack(robot);
            }
            robot.turnRight();
        }
    }

    void goBack(Robot robot){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    interface Robot {
        boolean move();
        void turnLeft();
        void turnRight();
        void clean();
    }

}
