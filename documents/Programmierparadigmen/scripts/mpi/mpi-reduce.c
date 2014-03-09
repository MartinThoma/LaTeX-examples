int MPI_Reduce(const void *sendbuf, void *recvbuf, 
                int count, MPI_Datatype datatype,
                MPI_Op op, int root, MPI_Comm comm)