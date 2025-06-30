import kotlin.math.abs

class Triangle(corner1: Point, corner2: Point, corner3: Point):Shape(listOf(corner1, corner2, corner3)) {
    private val vector1 = arrayOf(corner2.getX()-corner1.getX(),corner2.getY()-corner1.getY())
    private val vector2 = arrayOf(corner3.getX()-corner1.getX(),corner3.getY()-corner1.getY())
    init{
        validateDimensions()
    }
    override fun validateDimensions() {
        if (vector1[1]*vector2[0]-vector1[0]*vector2[1]==0.0) {
            throw IllegalArgumentException("The 3 points of a triangle cannot be collinear")
        }
    }
    fun getArea(): Double {
        return abs(vector1[1]*vector2[0]-vector1[0]*vector2[1]/2.0)
    }
    fun getCorners(): List<Point> = getPoints()
}