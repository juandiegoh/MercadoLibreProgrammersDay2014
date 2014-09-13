package com.jherenu.meli_min_path

class LadiesCasanova {

    def caminoAChicas(N,M,X0,Y0,X1,Y1,X2,Y2,X3,Y3,X4,Y4,X5,Y5,X6,Y6) {
        roadToGirls(N,M,X0,Y0,X1,Y1,X2,Y2,X3,Y3,X4,Y4,X5,Y5,X6,Y6)
    }

    def roadToGirls(N,M,X0,Y0,X1,Y1,X2,Y2,X3,Y3,X4,Y4,X5,Y5,X6,Y6) {
        def minPathResolver = new MinPathResolver()

        def seeker = new Position(X0, Y0)
        def coffee = new Position(X1, Y1)
        def snacks = new Position(X2, Y2)
        def boss = new Obstacle(new Position(X3,Y3), new Position(X4,Y4))

        def girls = new Rectangle(new Position(X5, Y5), new Position(X6, Y6))
        def girlsAsObstacles = new Obstacle(new Position(X5, Y5), new Position(X6, Y6))

        def allObstacles = [boss, girlsAsObstacles]
        def bossObstacle = [boss]

        Board fromSeekerToCoffeeBoard = new Board(N, M, allObstacles)
        def fromSeekerToCoffeeResult = minPathResolver.calculateMinPath(fromSeekerToCoffeeBoard, seeker, coffee)

        Board fromCoffeeToSnacksBoard = new Board(N, M, allObstacles)
        def fromCoffeeToSnacksResult = minPathResolver.calculateMinPath(fromCoffeeToSnacksBoard, coffee, snacks)

        Board fromSnacksToGirlsBoard = new Board(N, M, bossObstacle)
        def fromSnacksToGirlsResult = minPathResolver.calculateMinPath(fromSnacksToGirlsBoard, snacks, girls)

        def result = fromSeekerToCoffeeResult + fromCoffeeToSnacksResult.tail() + fromSnacksToGirlsResult.tail()
        return "[${result.join(",")}],${result.size()}"
    }
}
