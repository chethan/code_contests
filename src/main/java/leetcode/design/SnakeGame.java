package leetcode.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SnakeGame {

    private static final Map<String, Position> directionMap;

    static {
        directionMap = new HashMap<>();
        directionMap.put("U", new Position(-1, 0));
        directionMap.put("R", new Position(0, 1));
        directionMap.put("L", new Position(0, -1));
        directionMap.put("D", new Position(1, 0));
    }

    int foodIndex;
    Deque<Position> snakePositions = new ArrayDeque<>();
    Set<Position> snakeCache = new HashSet<>();
    private final int[][] food;
    private final int width;
    private final int height;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.snakePositions.add(new Position(0, 0));
        this.snakeCache.add(new Position(0, 0));
    }

    public int move(String direction) {
        //move
        Position head = snakePositions.peekFirst();
        Position tail = snakePositions.peekLast();
        Position newHead = head.add(directionMap.get(direction));
        //check boundaries
        boolean isWithinBoundary = newHead.isWithinBoundary(width, height);
        // Checking if the snake bites itself.
        boolean bitesItself = snakeCache.contains(newHead) && !newHead.equals(tail);
        if (!isWithinBoundary || bitesItself) {
            return -1;
        }
        if (foodIndex < food.length && newHead.equals(
            new Position(food[foodIndex][0], food[foodIndex][1]))) {
            foodIndex++;
        } else {
            snakePositions.pollLast();
            snakeCache.remove(tail);
        }
        snakePositions.addFirst(newHead);
        snakeCache.add(newHead);
        return snakePositions.size() - 1;

    }


    private static class Position {

        private final int x;
        private final int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Position add(Position other) {
            return new Position(this.x + other.x, this.y + other.y);
        }

        public boolean isWithinBoundary(int width, int height) {
            return x >= 0 && y >= 0 && x < height && y < width;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }


        public boolean equals(Object o) {
            if (!(o instanceof Position)) {
                return false;
            }
            Position other = (Position) o;
            return this.x == other.x && this.y == other.y;
        }
    }
}
/**
 * Your SnakeGame object will be instantiated and called as such: SnakeGame obj = new
 * SnakeGame(width, height, food); int param_1 = obj.move(direction);
 */
