#include "mpi.h"
...
int signal, i, numprogs, me;
MPI_Status stat;
MPI_Comm_rank(MPI_COMM_WORLD, &me);
MPI_Comm_size(MPI_COMM_WORLD, 
             &numprocs);
if (me==ROOT) {
    ... 
for (i=1; i<numprocs; i++) {
    MPI_Send(&signal, 1, MPI_INT, i, 0, MPI_COMM_WORLD);
}
... 
else {
    MPI_Recv(&sig, 1, MPI_INT, ROOT, MPI_ANY_TAG,
             MPI_COMM_WORLD, &stat);
    ... 
}