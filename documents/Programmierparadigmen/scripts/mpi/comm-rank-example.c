#include "mpi.h" 

    int       rank;
    MPI_Comm  comm;

    ...
    MPI_Comm_rank(comm, &rank);
    if (rank==0) {
        ... Code fur Prozess 0 ... 
    }
    else {
        ... Code fur die anderen Prozesse ... 
    }