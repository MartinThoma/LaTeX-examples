#!/usr/bin/python
# -*- coding: utf-8 -*-

class Node(object):
    """ A node. """

    def __init__(self, x, y, data):
        self._data  = data  # data connected to the node
        self._x     = x     # x-position
        self._y     = y     # y-position

    data    = property(fget=lambda self: self._data)
    x       = property(fget=lambda self: self._x)
    y       = property(fget=lambda self: self._y)

    def __str__(self):
        return "{(%i,%i)/%s}" % (self.x, self.y, str(self.data))

    def __repr__(self):
        return "{(%i,%i)/%s}" % (self.x, self.y, str(self.data))

class Edge(object):
    """ An edge. """

    def __init__(self, startNode, endNode, weight=0, directed=False):
        self._startNode = startNode
        self._endNode   = endNode
        self._weight    = weight
        self._directed  = directed

    startNode   = property(fget=lambda self: self._startNode)
    endNode     = property(fget=lambda self: self._endNode)
    weight      = property(fget=lambda self: self._weight)
    directed    = property(fget=lambda self: self._directed)

    def __str__(self):
        return "%s/%s/%i" % (str(id(self.startNode)), str(id(self.endNode)), self.weight)

    def __repr__(self):
        return "%s/%s/%i" % (str(id(self.startNode)), str(id(self.endNode)), self.weight)

class Graph(object):
    """ A graph. """

    def __init__(self, directed=False):
        self._directed  = directed
        self._edges     = []
        self._vertices  = []

    directed    = property(fget=lambda self: self._directed)
    edges       = property(fget=lambda self: self._edges)
    vertices    = property(fget=lambda self: self._vertices)

    def printVertices(self):
        vertexString = ""
        for vertex in self.vertices:
            vertexString += str(vertex)
        return vertexString

    def printEdges(self):
        edgeString = "% Connect vertices with edges and draw weights\n"
        edgeString += "\\foreach \source/ \dest /\weight in {"
        for i, edge in enumerate(self.edges):
            if i != 0:
                edgeString += ", "
            edgeString += str(edge)
        edgeString += "}\n"
        edgeString += "\path[edge] (\source) -- node[weight] {$\weight$} (\dest);"
        return edgeString

    def printGraph(self):
        print("\\begin{tikzpicture}[scale=1.8, auto,swap]")
        print("\\foreach \pos/\\name in {" + self.printVertices() + "}")
        print("\t\\node[vertex] (\\name) at \pos {$\\name$};")
        print(self.printEdges())
        print("\end{tikzpicture}")

if '__main__' == __name__:
    graph = Graph()
    k1 = Node(1,2, 1)
    k2 = Node(3,0, 2)
    k3 = Node(3,3, 3)
    k6 = Node(1,4, 6)
    k5 = Node(4,5, 5)
    k4 = Node(5,3, 4)
    graph._vertices.append(k1)
    graph._vertices.append(k2)
    graph._vertices.append(k3)
    graph._vertices.append(k4)
    graph._vertices.append(k5)
    graph._vertices.append(k6)
    graph._edges.append(Edge(k1,k2, 7))
    graph.printGraph()
