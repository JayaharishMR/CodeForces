class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        char[] arr = s.toCharArray();
        int ones = 0;
        for (char c : arr) {
            if (c == '1') ones++;
        }
        int start = 0;
        int i = 0;
        int bestGain = 0;
        int prev = -1;
        int curr = 0;
        int n = s.length();
        while (i < n) {
            start = i;
            while (i < n && arr[i] == arr[start]){
                i++;
            }
            if (arr[start] == '0') {
                curr = i - start;
                if (prev != -1) {
                    bestGain = Math.max(bestGain, prev+curr);
                }
                prev = curr;
            }
        }
        return ones+bestGain;
    }

    public int helper(int i, char[] arr){
        int count = 0;
        for (int j = i+1; j < arr.length-1; j++){
            if (arr[j] == '1'){
                break;
            }
            count++;
        }
        return count;
    }
}