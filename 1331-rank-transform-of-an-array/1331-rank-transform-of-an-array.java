class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        Map<Integer,Integer> hm = new HashMap<>();
        int count = 1;
        for (int i = 0; i < temp.length; i++) {
            if (hm.get(temp[i]) == null) {
                hm.put(temp[i], count);
                count++;
            } 
        }

        for (int i = 0; i < arr.length; i++){
            arr[i] = hm.get(arr[i]);
        }
        
        return arr;
    }
}