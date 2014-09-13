package com.jherenu.meli_min_path

class Obstacle extends Rectangle {

    Obstacle(Object pos1, Object pos2) {
        super(pos1, pos2)
    }

    boolean isValid(position) {
        def insideRectangle = position.isIn(pos1, pos2)
        return !insideRectangle
    }
}
