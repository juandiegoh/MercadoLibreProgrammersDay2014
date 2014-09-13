package com.jherenu.meli_min_path

class Board {

    static final MAX_VALUE = Integer.MAX_VALUE
    int columns
    int rows
    def obstacles

    def unvisitedNodes = []
    def visitedNodes = []

    public Board(columns, rows, obstacles) {
        this.columns = columns
        this.rows = rows
        this.obstacles = obstacles
        this.unvisitedNodes = getNodes()
    }

    def getNodes() {
        def positions = []
        (1..columns).each { i->
            (1..rows).each { j ->
                positions.add(new Node(new Position(i, j), MAX_VALUE))
            }
        }
        return positions
    }

    boolean hasUnvisitedNodes() {
        return !this.unvisitedNodes.isEmpty()
    }

    def getValidNeighborsForNode(Node node) {
        node.getNeighborsPositions().findAll { position ->
            isValid(position)
        }
    }

    boolean isValid(position) {
        return position.isIn(new Position(1,1), new Position(columns, rows)) && obstacles.every { it.isValid(position) }
    }

    def updateUnvisitedNodeWeightInPositionFromNode(Position position, parentNode) {
        def unvisitedNode = this.unvisitedNodes.find { unvisited -> unvisited.isSamePosition(position) }
        unvisitedNode?.updateWeight(parentNode)
    }

    def markNodeAsVisited(node) {
        this.unvisitedNodes.remove(node)
        this.visitedNodes.add(node)
    }

    Node getMinimumUnvisitedNode() {
        return this.unvisitedNodes.min { it.weight }
    }

    def getVisitedNodeFromPosition(Position position) {
        this.visitedNodes.find { visited -> visited.isSamePosition(position) }
    }
}
