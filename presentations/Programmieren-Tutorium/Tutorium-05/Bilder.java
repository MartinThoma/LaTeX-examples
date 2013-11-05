public static int getAverageColor(int[][] image) {
    int sum = 0;
    for (int x = 0; x < image.length; x++) {
        for (int y = 0; y < image[0].length; y++) {
            sum += image[x][y];
        }
    }
    return sum / (image.length * image[0].length);
}
