package com.jherenu.meli_min_path

class MinPathResolver {

    public static final int INITIAL_WEIGHT = 0

    def calculateMinPath(Board board, Position initialPosition, Perimetreable finalPosition) {
        return finalPosition.getPerimeterPositions().collect {
            doCalculateMinPath(board, initialPosition, it)
        }?.min { it.size() }
    }

    private def doCalculateMinPath(Board board, Position initialPosition, Position finalPosition) {
        def currentNode = createInitialNodeFromPosition(initialPosition)
        while(board.hasUnvisitedNodes()) {
            def neighbors = board.getValidNeighborsForNode(currentNode)
            neighbors.each {
                board.updateUnvisitedNodeWeightInPositionFromNode(it, currentNode)
            }

            board.markNodeAsVisited(currentNode)
            currentNode = board.getMinimumUnvisitedNode()
        }

        def processedFinalNode = board.getVisitedNodeFromPosition(finalPosition)
        return generateMinPathFromFinalToInitial(processedFinalNode, initialPosition).reverse()
    }

    private Node createInitialNodeFromPosition(Position initialPosition) {
        new Node(initialPosition, INITIAL_WEIGHT)
    }

    def generateMinPathFromFinalToInitial(finalNode, initialPosition) {
        def result = []
        def currentPosition = finalNode
        while(currentPosition) {
            result.add(currentPosition.getPosition())
            currentPosition = currentPosition.previousPosition
        }

        if(result.find { it == initialPosition }) {
            return result
        } else {
            throw new RuntimeException("We could not find a solution!! Are you sure this problem is solvable???")
        }
    }
}
