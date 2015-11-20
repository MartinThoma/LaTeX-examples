def strongly_connected_components(graph):
    index_counter = 0
    stack = []
    lowlinks = {}
    index = {}
    result = []

    def strongconnect(node, index_counter):
        index[node] = index_counter
        lowlinks[node] = index_counter
        index_counter += 1
        stack.append(node)

        try:
            successors = graph[node]
        except:
            successors = []

        # Depth first search
        for successor in successors:
            # Does the current node point to a node that was already
            # visited?
            if successor not in lowlinks:
                # Successor has not yet been visited; recurse on it
                strongconnect(successor, index_counter)
                lowlinks[node] = min(lowlinks[node], lowlinks[successor])
            elif successor in stack:
                # the successor is in the stack and hence in the
                # current strongly connected component (SCC)
                lowlinks[node] = min(lowlinks[node], index[successor])

        # If `node` is a root node, pop the stack and generate an SCC
        if lowlinks[node] == index[node]:
            connected_component = []

            while True:
                successor = stack.pop()
                connected_component.append(successor)
                if successor == node:
                    break

            component = tuple(connected_component)

            # storing the result
            result.append(component)

    for node in graph:
        if node not in lowlinks:
            strongconnect(node, index_counter)

    return result
