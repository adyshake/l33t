//https://leetcode.com/problems/k-closest-points-to-origin/
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        Comparator<Pair> comp = new PairComparator();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(10, comp);
                
        for (int i = 0; i < points.length; i++) {
            int a = points[i][0];
            int b = points[i][1];
            
            int dist = a*a + b*b;
            System.out.println(dist);

            maxHeap.add(new Pair(a, b, dist));
            
            if (maxHeap.size() > K) {
                Pair r = maxHeap.remove();
                System.out.println(r.dist);
            }
        }
        
        int result[][] = new int[K][2];
        int i = 0;
        while (maxHeap.size() > 0) {
            Pair p = maxHeap.remove();
            result[i][0] = p.a;
            result[i][1] = p.b;
            i++;
        }
        return result;
    }
}

public class PairComparator implements Comparator<Pair> {
    public int compare(Pair x, Pair y) {
        int dist1 = x.dist;
        int dist2 = y.dist;
        
        if (dist1 < dist2) {
            return 1;
        }
        else if (dist1 > dist2) {
            return -1;
        }
        return 0;
    }
}

class Pair {
    int a;
    int b;
    int dist;
    
    public Pair(int a, int b, int dist) {
        this.a = a;
        this.b = b;
        this.dist = dist;
    }
}
