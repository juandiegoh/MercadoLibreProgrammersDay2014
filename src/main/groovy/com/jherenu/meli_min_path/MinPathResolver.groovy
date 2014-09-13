package com.jherenu.meli_min_path

class MinPathResolver {

    public static final int INITIAL_WEIGHT = 0

    def calculateMinPath(Board board, Position initialPosition, Perimetreable finalPosition, Collection<Obstacle> obstacles) {
        return finalPosition.getPerimeterPositions().collect {
            doCalculateMinPath(board, initialPosition, it, obstacles)
        }?.min { it.size() }
    }

    private def doCalculateMinPath(Board board, Position initialPosition, Position finalPosition, Collection<Obstacle> obstacles) {
        def visitedPositions = []
        def unvisitedPositions = board.getNodes()

        def currentPosition = createInitialNodeFromPosition(initialPosition)
        while(!unvisitedPositions.isEmpty()) {
            def neighbors = currentPosition.getNeighbors(board, obstacles)
            neighbors.each {
                def neighbor = unvisitedPositions.find { unvisited -> unvisited.isSamePosition(it) }
                neighbor?.updateWeight(currentPosition)
            }
            unvisitedPositions.remove(currentPosition)
            visitedPositions.add(currentPosition)
            currentPosition = unvisitedPositions.min { it.weight }
        }

        def processedFinalPosition = visitedPositions.find { visited -> visited.isSamePosition(finalPosition) }
        def result = generateMinPathFromFinalToInitial(processedFinalPosition).reverse()

        return result
    }

    private Node createInitialNodeFromPosition(Position initialPosition) {
        new Node(initialPosition, INITIAL_WEIGHT)
    }

    def generateMinPathFromFinalToInitial(finalPosition) {
        def result = []
        def currentPosition = finalPosition
        while(currentPosition) {
            result.add(currentPosition.getPosition())
            currentPosition = currentPosition.previousPosition
        }
        return result
    }
}
