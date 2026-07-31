class Solution {
    public int minimumPushes(String word) {
        Map<String, Integer> hm = new HashMap<>();
        if (word.length() <= 8) {
            return word.length();
        }
        for (int i = 0; i < word.length(); i++) {
            hm.put(String.valueOf(word.charAt(i)), hm.getOrDefault(String.valueOf(word.charAt(i)),0)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
            Map.Entry.<String, Integer>comparingByValue().reversed()
        );
        pq.addAll(hm.entrySet());
        int count = 0;
        int distinct = 0;
        while (!pq.isEmpty()) {
            Map.Entry<String, Integer> entry = pq.poll();
            int value = entry.getValue();
            //System.out.println("count: "+count+"key: "+entry.getKey()+"value: "+entry.getValue());
            for (int i  = 0; i < value; i++) {
                count = count + 1+ distinct/8;
            }
            distinct++;
        }
        return count;
    }
}