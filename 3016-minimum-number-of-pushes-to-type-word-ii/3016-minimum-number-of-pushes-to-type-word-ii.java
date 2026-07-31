class Solution {
    public int minimumPushes(String word) {
        Map<String, Integer> hm = new HashMap<>();
        if (word.length() <= 8) {
            return word.length();
        }
        for (int i = 0; i < word.length(); i++) {
            hm.put(String.valueOf(word.charAt(i)), hm.getOrDefault(String.valueOf(word.charAt(i)),0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> b - a
        );
        pq.addAll(hm.values());
        int count = 0;
        int distinct = 0;
        while (!pq.isEmpty()) {
            //System.out.println("count: "+count+"key: "+entry.getKey()+"value: "+entry.getValue());
            int value = pq.poll();
            count += value * (1 + (distinct/8));
            distinct++;
        }
        return count;
    }
}