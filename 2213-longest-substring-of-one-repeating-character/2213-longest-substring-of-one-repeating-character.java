class Solution {
    String s;
    Node[] tree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        this.s = s;
        int n = s.length();
        tree = new Node[4*n];

        build(1,0,n-1);

        int[] res = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            int index = queryIndices[i];
            char c = queryCharacters.charAt(i);
            update(1,0,n-1,index,c);
            res[i] = tree[1].maxLength;
        }

        return res;
    }

    class Node {
        int length;
        int leftLength;
        int rightLength;
        int maxLength;
        char leftChar;
        char rightChar;

        Node(int length, int leftLength, int rightLength, int maxLength, char leftChar, char rightChar) {
            this.length = length;
            this.leftLength = leftLength;
            this.rightLength = rightLength;
            this.maxLength = maxLength;

            this.leftChar = leftChar;
            this.rightChar = rightChar;
        }
    }
    
    public Node merge(Node leftNode, Node rightNode) {
        int length = leftNode.length + rightNode.length;
        int maxLength = Math.max(leftNode.maxLength, rightNode.maxLength);
        int leftLength = leftNode.leftLength;
        int rightLength = rightNode.rightLength;

        if (leftNode.rightChar == rightNode.leftChar) {
            int crossed = leftNode.rightLength+rightNode.leftLength;
            maxLength = Math.max(maxLength, crossed);

            if (leftNode.leftLength == leftNode.length) {
                leftLength = leftNode.length + rightNode.leftLength;
            }

            if (rightNode.rightLength == rightNode.length) {
                rightLength = rightNode.length + leftNode.rightLength;
            }
        }

        return new Node(length, leftLength, rightLength, maxLength, leftNode.leftChar, rightNode.rightChar);  
    }

    public void build(int node, int start, int end) {
        // System.out.println(node+" "+start+" "+end);
        if (start == end) {
            tree[node] = new Node(1,1,1,1,s.charAt(start),s.charAt(start));
            return;
        }

        int mid = (start+end)/2;

        build(node*2, start, mid);
        build((node*2)+1, mid+1, end);
        
        tree[node] = merge(tree[node*2], tree[(node*2)+1]);
    }

    public void update(int node, int start, int end, int index, char c) {
        if (start == end) {
            tree[node] = new Node(1,1,1,1,c,c);
            return;
        }

        int mid = (start+end)/2;

        if (index <= mid) {
            update(node*2,start,mid,index,c);
        } else {
            update((node*2)+1,mid+1,end,index,c);
        }
        tree[node] = merge(tree[node*2], tree[(node*2)+1]);
    }
}

