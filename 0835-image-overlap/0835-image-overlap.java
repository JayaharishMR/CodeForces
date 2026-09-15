class Solution {

    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;
        int maxOverlap = 0;

        // Move vertically
        for (int vertical = -(n - 1); vertical <= n - 1; vertical++) {

            // Move horizontally
            for (int horizontal = -(n - 1); horizontal <= n - 1; horizontal++) {

                int[][] moved = deepCopy(img1);

                // Vertical movement
                if (vertical < 0) {
                    for (int i = 0; i < -vertical; i++) {
                        moved = move(moved, 'u');
                    }
                } else {
                    for (int i = 0; i < vertical; i++) {
                        moved = move(moved, 'd');
                    }
                }

                // Horizontal movement
                if (horizontal < 0) {
                    for (int i = 0; i < -horizontal; i++) {
                        moved = move(moved, 'l');
                    }
                } else {
                    for (int i = 0; i < horizontal; i++) {
                        moved = move(moved, 'r');
                    }
                }

                int currOverlap = helper(moved, img2);

                maxOverlap = Math.max(maxOverlap, currOverlap);
            }
        }

        return maxOverlap;
    }


    public static int[][] deepCopy(int[][] original) {

        if (original == null) {
            return null;
        }

        int[][] result = new int[original.length][];

        for (int i = 0; i < original.length; i++) {
            result[i] = original[i].clone();
        }

        return result;
    }


    public int[][] move(int[][] img1, char c) {

        int n = img1.length;

        int[][] img = deepCopy(img1);

        if (c == 'l') {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n - 1; j++) {
                    img[i][j] = img[i][j + 1];
                }

                img[i][n - 1] = 0;
            }
        }


        if (c == 'r') {

            for (int i = 0; i < n; i++) {

                for (int j = n - 1; j >= 1; j--) {
                    img[i][j] = img[i][j - 1];
                }

                img[i][0] = 0;
            }
        }


        if (c == 'u') {

            for (int j = 0; j < n; j++) {

                for (int i = 0; i < n - 1; i++) {
                    img[i][j] = img[i + 1][j];
                }

                img[n - 1][j] = 0;
            }
        }


        if (c == 'd') {

            for (int j = 0; j < n; j++) {

                for (int i = n - 1; i >= 1; i--) {
                    img[i][j] = img[i - 1][j];
                }

                img[0][j] = 0;
            }
        }

        return img;
    }


    public int helper(int[][] img1, int[][] img2) {

        int n = img1.length;
        int res = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (img1[i][j] == 1 && img1[i][j] == img2[i][j]) {
                    res++;
                }
            }
        }

        return res;
    }
}