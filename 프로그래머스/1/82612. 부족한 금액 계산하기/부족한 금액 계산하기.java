class Solution {
    public long solution(int price, int money, int count) {
        long payment = 0;
        long balance = 0;
        for (int i = 1; i <= count; i++) {
            payment += price * i;
        }
        
        balance = money - payment;

        return balance >= 0 ? 0 : Math.abs(balance);
    }
}