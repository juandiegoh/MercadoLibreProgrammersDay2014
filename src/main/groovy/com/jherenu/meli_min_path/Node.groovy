package com.jherenu.meli_min_path

class Node {
    Position position
    Integer weight
    Node previousPosition

    def Node(position, int weight = Integer.MAX_VALUE) {
        this.position = position
        this.weight = weight
    }

    def getNeighborsPositions() {
        return position.generateNeighbors()
    }

    def updateWeight(previousNode) {
        if(weight > previousNode.weight+1) {
            this.weight = previousNode.weight+1
            this.previousPosition = previousNode
        }
    }

    boolean isSamePosition(position) {
        this.position.equals(position)
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
