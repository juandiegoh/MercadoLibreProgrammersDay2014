package com.jherenu.meli_min_path

class Rectangle implements Perimetreable {
    def pos1
    def pos2

    public Rectangle(pos1, pos2) {
        this.pos1 = pos1
        this.pos2 = pos2
    }

    def getPerimeterPositions() {
        return Position.getPerimeterOfRectangle(this)
    }
}
