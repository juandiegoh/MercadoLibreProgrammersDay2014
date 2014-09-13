package com.jherenu.meli_min_path

class Position implements Perimetreable {
    Integer row
    Integer column

    public Position(column, row) {
        this.row = row
        this.column = column
    }

    static def getPerimeterOfRectangle(Rectangle rectangle) {
        def perimeter = []
        Position pos1 = rectangle.getPos1()
        Position pos2 = rectangle.getPos2()

        def acceptedRows = [pos1.row, pos2.row]
        def acceptedColumns = [pos1.column, pos2.column]
        (rectangle.pos1.column..rectangle.pos2.column).each { _column ->
            (rectangle.pos1.row..rectangle.pos2.row).each { _row ->
                if(acceptedRows.contains(_row) || acceptedColumns.contains(_column)) {
                    perimeter.add(new Position(_column, _row))
                }
            }
        }
        return perimeter
    }

    boolean isIn(position1, position2) {
        (position1.column..position2.column).contains(column) && (position1.row..position2.row).contains(row)
    }

    def generateNeighbors() {
        return [
                new Position(column+1, row),
                new Position(column, row-1),
                new Position(column-1, row),
                new Position(column, row+1)
        ]
    }

    def getPerimeterPositions() {
        return [this]
    }

    public boolean equals(other) {
        if (other == null) return false
        if (this.is(other)) return true
        if (!(other instanceof Position)) return false
        if (column != other.column) return false
        if (row != other.row) return false
        return true
    }

    public String toString() {
        return "($column,$row)"
    }
}
