package com.jherenu.meli_min_path

class LadiesCasanova {

    def caminoAChicas(N,M,X0,Y0,X1,Y1,X2,Y2,X3,Y3,X4,Y4,X5,Y5,X6,Y6) {
        roadToGirls(N,M,X0,Y0,X1,Y1,X2,Y2,X3,Y3,X4,Y4,X5,Y5,X6,Y6)
    }

    def roadToGirls(N,M,X0,Y0,X1,Y1,X2,Y2,X3,Y3,X4,Y4,X5,Y5,X6,Y6) {
        def minPathResolver = new MinPathResolver()

        Board board = new Board(columns: N, rows: M)
        def seeker = new Position(X0, Y0)
        def coffee = new Position(X1, Y1)
        def snacks = new Position(X2, Y2)
        def boss = new Obstacle(new Position(X3,Y3), new Position(X4,Y4))

        def girls = new Rectangle(new Position(X5, Y5), new Position(X6, Y6))
        def girlsAsObstacles = new Obstacle(new Position(X5, Y5), new Position(X6, Y6))

        def allObstacles = [boss, girlsAsObstacles]
        def bossObstacle = [boss]

        def fromSeekerToCoffee = minPathResolver.calculateMinPath(board, seeker, coffee, allObstacles)
        def fromCoffeeToSnacks = minPathResolver.calculateMinPath(board, coffee, snacks, allObstacles)
        def fromSnacksToGirls = minPathResolver.calculateMinPath(board, snacks, girls, bossObstacle)

        def result = fromSeekerToCoffee + fromCoffeeToSnacks.tail() + fromSnacksToGirls.tail()
        return "[${result.join(",")}],${result.size()}"
    }
}
