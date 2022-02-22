package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class HitCounter {

    private final Deque<Pair> hitMap = new ArrayDeque<>();
    private int total = 0;

    public HitCounter() {
    }

    public void hit(int timestamp) {
        cleanUpOldHits(timestamp);
        Pair lastTimeStampPair = hitMap.peekLast();
        if (hitMap.isEmpty() || lastTimeStampPair.timeStamp != timestamp) {
            hitMap.offerLast(new Pair(timestamp, 1));
        } else {
            lastTimeStampPair.count = lastTimeStampPair.count + 1;
        }
        total++;
    }

    public int getHits(int timestamp) {
        cleanUpOldHits(timestamp);
        return total;
    }

    private void cleanUpOldHits(int timestamp) {
        while (!hitMap.isEmpty()) {
            int t = hitMap.peek().timeStamp;
            int diff = timestamp - t;
            if (diff >= 300) {
                total -= hitMap.peek().count;
                hitMap.poll();
            } else {
                break;
            }
        }
    }

    private static class Pair {

        int timeStamp;
        int count;

        Pair(int timeStamp, int count) {
            this.timeStamp = timeStamp;
            this.count = count;
        }
    }
}
