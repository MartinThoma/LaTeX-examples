// Quelle: Klausur vom SS 2013 am KIT bei 
// Prof. Dr.-Ing. Gregor Snelting
void my_int_sum_reduce(int *sendbuf, 
    int *recvbuf, int count,
    int root, MPI_Comm comm)
{
    int size, rank;
    MPI_Comm_size(comm, &size);
    MPI_Comm_rank(comm, &rank);
    if (rank == root) {
        /* Initialize recvbuf with our own values. */
        for (int i = 0; i < count; ++i) {
            recvbuf[i] = sendbuf[i];
        }

        /* Receive values from every other node
           and accumulate. */
        for (int i = 0; i < size; ++i) {
            if (i == root)
                continue;

            int other[count];
            MPI_Recv(other, count, MPI_INT, 
                i, 0, comm, MPI_STATUS_IGNORE);
            
            for (int j = 0; j < count; ++j) {
                recvbuf[j] += other[j];
            }
        }
    } else {
        /* Send our values to root. */
        MPI_Send(sendbuf, count, MPI_INT, 
            root, 0, comm);
    }
}