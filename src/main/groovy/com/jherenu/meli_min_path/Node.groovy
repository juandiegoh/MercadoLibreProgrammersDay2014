package com.jherenu.meli_min_path

class Node {
    public static final INFINITY_WEIGHT = Integer.MAX_VALUE

    Position position
    Integer weight
    Node previousPosition

    def Node(position, int weight = INFINITY_WEIGHT) {
        this.position = position
        this.weight = weight
    }

    def getNeighborsPositions() {
        return position.generateNeighbors()
    }

    def updateWeightFromNode(previousNode) {
        if (weight > previousNode.weight + 1) {
            this.weight = previousNode.weight + 1
            this.previousPosition = previousNode
        }
    }

    def updateWeight(newWeight) {
        this.weight = newWeight
    }

    boolean isSamePosition(position) {
        this.position.equals(position)
    }

    boolean hasInfinityWeight() {
        this.weight == INFINITY_WEIGHT
    }

    public boolean equals(other) {
        if (other == null) return false
        if (this.is(other)) return true
        if (!(other instanceof Node)) return false
        if (position != other.position) return false
        return true
    }

    public String toString() {
        return "(${position})"
    }
}
