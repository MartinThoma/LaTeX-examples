void my_bcast(void* data, int count, 
    MPI_Datatype type,
    int root, MPI_Comm comm) {

    int my_rank, comm_size;
    MPI_Comm_rank(comm, &my_rank);
    MPI_Comm_size(comm, &comm_size);

    if (my_rank == root) {
        // If we are the root process, send our 
        // data to every one
        for (int i = 0; i < comm_size; i++) {
            if (i != my_rank) {
                MPI_Send(data, count, 
                    type, i, 0, comm);
            }
        }
    } else {
        // If we are a receiver process, 
        // receive the data from root
        MPI_Recv(data, count, type, root, 0, 
            comm, MPI_STATUS_IGNORE);
    }
}
