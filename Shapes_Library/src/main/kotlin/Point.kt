class Point (
    private var x: Double,
    private var y: Double
){
    fun getX(): Double = x
    fun getY(): Double = y
    fun clone(): Point = Point(x, y)
    fun move(dx: Double, dy: Double){
        x += dx
        y += dy
    }
}