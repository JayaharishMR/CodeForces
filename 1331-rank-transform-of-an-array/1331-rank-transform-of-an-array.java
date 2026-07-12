class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            temp[i]= arr[i];
        }
        Arrays.sort(temp);
        Map<Integer,Integer> hm = new HashMap<>();
        int count = 1;
        for (int i = 0; i < temp.length; i++) {
            if (hm.get(temp[i]) == null) {
                hm.put(temp[i], count);
                count++;
            } 
        }

        int[]res = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            res[i] = hm.get(arr[i]);
        }
        
        return res;
    }
}