def getL(A):
    n = len(A)
    L = [[0 for i in range(n)] for j in range(n)]
    print(L)
    print("")
 
    for k in range(n):
        L[k][k] = (A[k][k] - sum([L[k][i]**2 for i in range(k)]))**0.5
        for i in range(k+1, n):
            L[i][k] = (A[i][k] 
                        - sum([L[i][j]*L[k][j] for j in range(k)])) \
                      / L[k][k]
            print("L_%i%i = A%i%i - sum(L_...)/L_%i%i) = %i" % (i, k, i, k, k, k, L[i][k]))
    return L

A = [[1,2,3],[2,8,14],[3,14,34]]

print getL(A)
