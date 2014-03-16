#include <stdio.h>
#include <mpi.h>
int main (int argc, char** args) {
    int size, i;
    int myrank;
    MPI_Init(&argc, &args);
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    MPI_Comm_rank(MPI_COMM_WORLD, &myrank);

    for (i=0; i<size; i++) {
        MPI_Barrier(MPI_COMM_WORLD);
        if (i == myrank) {
            printf("Hello World, I have rank %d out of %d.\n",
                myrank, size);
        }
    }

    MPI_Finalize();
    return 0;
}