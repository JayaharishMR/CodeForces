class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        Stack<Character> st = new Stack();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push('(');
            } else if (c == ')'){
                st.pop();
            }

            ans = Math.max(ans,st.size());
        }
        return ans;
    }
}