#!/usr/bin/env python

import scipy.signal
import numpy as np

image = [[104, 116, 116, 112, 58, 47, 47],
         [109, 97, 114, 116, 105, 110, 45],
         [116, 104, 111, 109, 97, 46, 100],
         [101, 47, 109, 97, 115, 116, 101],
         [114, 47, 99, 97, 116, 99, 97],
         [116, 99, 97, 116, 46, 112, 104],
         [112, 63, 118, 61, 49, 46, 48]]

filter_kernel = [[9, -3, -1],
                 [-6, 5, 3],
                 [2, -8, 0]]
filter_kernel = np.array(filter_kernel)
res = scipy.signal.convolve2d(image, filter_kernel[::-1, ::-1],
                              mode='same', boundary='fill', fillvalue=0)
print(res)
