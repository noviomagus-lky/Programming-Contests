class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        
        int sum = numBottles;
        int bottle = numBottles;
        
        while(bottle >= numExchange) {
            sum += bottle/numExchange;
            bottle = bottle/numExchange + bottle % numExchange;
            
        }
        
        return sum;
    }
}
