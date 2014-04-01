int MPI_Gather(void *sendbuf, int sendcount, 
    MPI_Datatype sendtype, 
    void *recvbuf, int recvcount, 
    MPI_Datatype recvtype, 
    int root, MPI_Comm comm)