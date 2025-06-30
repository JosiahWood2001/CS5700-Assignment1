import kotlin.math.abs

open class Rectangle(corner1: Point, corner2: Point):Shape(listOf(corner1, corner2)) {
    protected var width: Double = abs(corner2.getX()-corner1.getX())
    protected var height: Double = abs(corner2.getY()-corner1.getY())
    init{
        validateDimensions()
    }
    override fun validateDimensions() {
        if (width == 0.0 || height == 0.0) {
            throw IllegalArgumentException("Rectangle cannot have 0 width or height")
        }
        if (!this.getArea().isFinite()){
            throw IllegalArgumentException("This shape is too large")
        }
    }
    fun getArea(): Double {
        return width*height
    }
    fun getCorners(): List<Point> = getPoints()
}