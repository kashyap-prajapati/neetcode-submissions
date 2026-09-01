class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas=0;
        int tank=0;
        int index=0;
        for(int i=0;i<gas.length;i++){
            tank = tank + gas[i] - cost[i];
            total_gas = total_gas + gas[i] - cost[i];

            if(tank<0){
                tank=0;
                index=i+1;
            }
        }
        if(total_gas<0){
            return -1;
        }

        return index;


    }
}
