def strongly_connected_components(graph):
    """
    Tarjan's Algorithm (named for its discoverer, Robert Tarjan) is a
    graph theory algorithm for finding the strongly connected
    components of a graph.

    Based on: http://en.wikipedia.org/wiki/Tarjan%27s_strongly_connected_components_algorithm
    @author: Dries Verdegem, some minor edits by Martin Thoma
    @source: http://www.logarithmic.net/pfh/blog/01208083168
    """

    index_counter = 0
    stack = []
    lowlinks = {}
    index = {}
    result = []

    def strongconnect(node, index_counter):
        print("Start with node: %s###########################" % node)
        # set the depth index for this node to the smallest unused index
        print("lowlinks:\t%s" % lowlinks)
        print("index:\t%s" % index)
        print("stack:\t%s" % stack)

        index[node] = index_counter
        lowlinks[node] = index_counter
        index_counter += 1
        stack.append(node)

        # Consider successors of `node`
        try:
            successors = graph[node]
        except:
            successors = []

        # Depth first search
        for successor in successors:
            # Does the current node point to a node that was already
            # visited?
            if successor not in lowlinks:
                print("successor not in lowlinks: %s -> %s (node, successor)" %
                      (node, successor))
                # Successor has not yet been visited; recurse on it
                strongconnect(successor, index_counter)
                lowlinks[node] = min(lowlinks[node], lowlinks[successor])
            elif successor in stack:
                # else:
                print("successor in stack: %s -> %s" % (node, successor))
                # the successor is in the stack and hence in the
                # current strongly connected component (SCC)
                lowlinks[node] = min(lowlinks[node], index[successor])
            else:
                print("This happens sometimes. node: %s, successor: %s" %
                      (node, successor))
                print("Lowlinks: %s" % lowlinks)
                print("stack: %s" % stack)

        # If `node` is a root node, pop the stack and generate an SCC
        if lowlinks[node] == index[node]:
            print("Got root node: %s (index/lowlink: %i)" %
                  (node, lowlinks[node]))
            connected_component = []

            while True:
                successor = stack.pop()
                print("pop: %s" % successor)
                connected_component.append(successor)
                if successor == node:
                    break

            component = tuple(connected_component)

            # storing the result
            result.append(component)
        else:
            print("Node: %s, lowlink: %i, index: %i" %
                  (node, lowlinks[node], index[node]))

    for node in graph:
        if node not in lowlinks:
            strongconnect(node, index_counter)

    return result

graph = {'a': ['b'],
         'b': ['c'],
         'c': ['d', 'e'],
         'd': ['a', 'e', 'h'],
         'e': ['c', 'f'],
         'f': ['g', 'i'],
         'g': ['h', 'f'],
         'h': ['j'],
         'i': ['g', 'f'],
         'j': ['i'],
         'k': [],
         'h': []}

print strongly_connected_components(graph)
