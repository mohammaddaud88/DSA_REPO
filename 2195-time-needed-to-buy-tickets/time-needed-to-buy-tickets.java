class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> que = new LinkedList<>();
        int time =0;
        for(int i=0;i<tickets.length;i++){
            que.add(i);
        }
        while(!que.isEmpty()){
            int person = que.poll();
            tickets[person]--;
            time++;

            if(person == k && tickets[k] == 0){
                return time;
            }
            if(tickets[person]>0){
                que.add(person);
            }
        }
        return time;
    }
}