class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int maxDamage = 0;
        long totalDamage = 0;
        for(int num : damage) {
            maxDamage = Math.max(maxDamage, num);
            totalDamage += num;
        }
        return totalDamage - Math.min(armor, maxDamage) + 1;
    }
}