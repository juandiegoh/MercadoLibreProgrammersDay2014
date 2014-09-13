package com.jherenu.meli_min_path

import spock.lang.Specification

class MinPathResolverSpec extends Specification {

    MinPathResolver minPathResolver
    Board board
    Position seeker
    Position coffee
    Position snacks
    def obstacles

    Rectangle girls
    Obstacle boss

    void setup() {
        this.minPathResolver = new MinPathResolver()
        this.board = new Board(columns: 8, rows: 8)
        this.seeker = new Position(2, 1)
        this.coffee = new Position(7, 2)
        this.snacks = new Position(2, 7)
        this.boss = new Obstacle(new Position(3,3), new Position(5,4))
        this.girls = new Rectangle(new Position(6, 6), new Position(7, 7))
        this.obstacles = [boss]
    }

    void "example test _ from initial position to coffee"() {
        given:
        def initialPosition = this.seeker
        def finalPosition = this.coffee

        when:
        def result = minPathResolver.calculateMinPath(board, initialPosition, finalPosition, obstacles)

        then:
        println "Size: ${result.size()} - path: ${result}"
        result == [p(2,1), p(2,2), p(3,2), p(4,2), p(5,2), p(6,2), p(7,2)]
    }

    void "example test _ from coffee position to snacks"() {
        given:
        def initialPosition = this.coffee
        def finalPosition = this.snacks

        when:
        def result = minPathResolver.calculateMinPath(board, initialPosition, finalPosition, obstacles)

        then:
        println "Size: ${result.size()} - path: ${result}"
        [[p(7,2),p(7,3),p(7,4),p(7,5),p(6,5),p(5,5),p(4,5),p(3,5),p(2,5),p(2,6),p(2,7)],
            [p(7, 2),p(6, 2),p(5, 2),p(4, 2),p(3, 2),p(2, 2),p(2, 3),p(2, 4),p(2, 5),p(2, 6),p(2, 7)]]
                .contains(result)
    }

    void "example test _ from snacks to minimum girls"() {
        given:
        def initialPosition = this.snacks
        def rectangleFinalPosition = this.girls

        when:
        def result = minPathResolver.calculateMinPath(board, initialPosition, rectangleFinalPosition, obstacles)

        then:
        println "Size: ${result.size()} - path: ${result}"
        result == [p(2,7),p(3,7),p(4,7),p(5,7),p(6,7)]
    }

    Position p(column, row) {
        new Position(column, row)
    }
}
