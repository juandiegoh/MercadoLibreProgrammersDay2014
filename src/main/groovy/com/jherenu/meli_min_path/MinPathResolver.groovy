package com.jherenu.meli_min_path

class MinPathResolver {

    public static final int INITIAL_WEIGHT = 0

    def calculateMinPath(Board board, Position initialPosition, Perimetreable finalPosition) {
        return finalPosition.getPerimeterPositions().collect {
            doCalculateMinPath(board, initialPosition, it)
        }?.min { it.size() }
    }

    private def doCalculateMinPath(Board board, Position initialPosition, Position finalPosition) {
        board.updateUnvisitedNodeWeightInPosition(initialPosition, INITIAL_WEIGHT)
        while(minPathNotFound(board, finalPosition)) {
            def currentNode = board.getMinimumUnvisitedNode()
            def neighbors = board.getValidNeighborsForNode(currentNode)
            neighbors.each {
                board.updateUnvisitedNodeWeightInPositionFromNode(it, currentNode)
            }
            board.markNodeAsVisited(currentNode)
        }

        def processedFinalNode = board.getVisitedNodeFromPosition(finalPosition)
        return generateMinPathFromFinalToInitial(processedFinalNode, initialPosition).reverse()
    }

    private boolean minPathNotFound(Board board, finalPosition) {
        return !minPathFound(board, finalPosition)
    }

    boolean minPathFound(Board board, finalPosition) {
        return finalPositionHasBeenVisited(board, finalPosition) || board.everyUnvisitedNodesHaveInfinityWeight()
    }

    private Object finalPositionHasBeenVisited(Board board, finalPosition) {
        board.getVisitedNodeFromPosition(finalPosition)
    }

    private def generateMinPathFromFinalToInitial(finalNode, initialPosition) {
        def result = []
        def currentNode = finalNode
        while(currentNode) {
            result.add(currentNode.getPosition())
            currentNode = currentNode.previousPosition
        }

        if(result.find { it == initialPosition }) {
            return result
        } else {
            throw new RuntimeException("We could not find a solution!! Are you sure this problem is solvable???")
        }
    }
}
