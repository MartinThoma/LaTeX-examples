for (int i = 0; i < image.length; i++) {
    for (int j = 0; j < image[i].length; j++) {
        assert(0 <= image[i][j] && image[i][j] <= 255);
        histogram[image[i][j]]++;
    }
}
