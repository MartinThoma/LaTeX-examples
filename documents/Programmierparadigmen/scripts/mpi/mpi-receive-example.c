#include "mpi.h"

int           msglen, again=1;
void          *buf;
MPI_Datatype  datatype
MPI_Comm      comm;
MPI_Status    status;

...  
while (again) {
MPI_Probe(ROOT, MPI_ANY_TAG, comm, &status);
    MPI_Get_count(&status, datatype, &msglen);
buf=malloc(msglen*sizeof(int));
MPI_Recv(buf, msglen, datatype, status.MPI_SOURCE, 
         status.MPI_TAG, comm, &status);
    ...
}
...