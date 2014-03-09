#include "mpi.h"

int  myid;
int  recvbuf[DATASIZE], sendbuf[DATA_SIZE];

...
/* Minimum bilden */
MPI_Reduce(sendbuf, recvbuf, DATA_SIZE, MPI_INT, MPI_MIN,
       0, MPI_COMM_WORLD);
...