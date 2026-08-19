class Solution {
        public class Pair{
              int node;
              int minutes;
             public Pair(int node,int minutes){
                  this.node = node;
                  this.minutes = minutes;
             }
        }
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
             adj.add(new ArrayList<>());
        } 
        for(int i = 0 ; i < edges.length ; i++){
              int u = edges[i][0];
              int v = edges[i][1];
               adj.get(u).add(new Pair(v, time));
adj.get(v).add(new Pair(u, time));
        }
        int[][] timearray = new int[n + 1][2];
for (int i = 0; i <= n; i++) {
    Arrays.fill(timearray[i], Integer.MAX_VALUE);
}
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int nod = p.node;
            int min = p.minutes;
            timearray[1][0] = 0;
            for(Pair currPair : adj.get(nod)){
                    int currTime = min;
                     if((currTime/change) % 2 == 1){
                         currTime = (currTime/change + 1) * change;
                     } 
                     int newTime = currTime + time;
if (newTime < timearray[currPair.node][0]) {
                    timearray[currPair.node][0] = newTime;
                    queue.add(new Pair(currPair.node, newTime));
                } else if (newTime > timearray[currPair.node][0] && newTime < timearray[currPair.node][1]) {
                    timearray[currPair.node][1] = newTime;
                    queue.add(new Pair(currPair.node, newTime));
                }
                }
            }
        return timearray[n][1];
    }
}