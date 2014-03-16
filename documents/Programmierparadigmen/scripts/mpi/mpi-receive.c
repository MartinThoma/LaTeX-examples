int MPI_Recv(void *buf, int count, 
             MPI_Datatype datatype, int source, int tag,
             MPI_Comm comm, MPI_Status *status)