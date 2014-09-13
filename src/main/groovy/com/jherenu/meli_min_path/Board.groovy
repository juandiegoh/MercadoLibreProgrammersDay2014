package com.jherenu.meli_min_path

class Board {

    static final MAX_VALUE = Integer.MAX_VALUE
    int columns
    int rows

    def getNodes() {
        def positions = []
        (1..columns).each { i->
            (1..rows).each { j ->
                positions.add(new Node(new Position(i, j), MAX_VALUE))
            }
        }
        return positions
    }

    boolean isValid(position) {
        return position.isIn(new Position(1,1), new Position(columns, rows))
    }
}
