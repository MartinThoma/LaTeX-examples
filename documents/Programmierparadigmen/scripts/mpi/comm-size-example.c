#include "mpi.h"

    int       size;
    MPI_Comm  comm;
    ...
    MPI_Comm_size(comm, &size); 
    ...