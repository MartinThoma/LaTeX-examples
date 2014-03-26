int MPI_Alltoall(const void *sendbuf, int sendcount, 
                 MPI_Datatype sendtype,
                 void *recvbuf, int recvcount, 
                 MPI_Datatype recvtype,
                 MPI_Comm comm)