#include <stdio.h>

int arr[] = {0,1,2,3,4,5};

int main() {
    printf("%i %i", arr[0], (&arr[3])[0]);
    return 0;
}