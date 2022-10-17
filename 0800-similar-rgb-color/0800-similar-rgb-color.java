class Solution {
    public String similarRGB(String color) {
        String s = "#";
        for(int i=1; i<color.length(); i += 2) {
            s += getSimString(color.substring(i, i + 2));
        }
        return s;
    }
    
    public String getSimString(String hex) {
        String ans = "";
        int diff = Integer.MAX_VALUE;
        for(int i=0; i<16; i++) {
            int num = 16*i + i;
            int decimal=Integer.parseInt(hex,16);
            if(Math.abs(num - decimal) < diff) {
                diff = Math.abs(num - decimal);
                ans = Integer.toHexString(i)+Integer.toHexString(i);
            }
        }
        return ans;
    }
}