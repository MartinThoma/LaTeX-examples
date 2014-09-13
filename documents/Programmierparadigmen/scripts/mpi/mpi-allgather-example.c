#include "mpi.h"

int           sendcount, recvcount;
void          *sendbuf, *recvbuf;
MPI_Datatype  sendtype, recvtype;
MPI_Comm      comm;

...
MPI_Allgather(sendbuf, sendcount, sendtype, 
              recvbuf, recvcount, recvtype, 
              comm);
...