import kotlin.math.abs
import kotlin.math.sqrt

class Line(a: Point, b: Point) : Shape(listOf(a,b)){
    init{
        validateDimensions()
    }
    override fun validateDimensions(){
        val a: Point = definingPoints[0]
        val b: Point = definingPoints[1]
        if (a.getX()==b.getX()&&a.getY()==b.getY()) {
            throw IllegalArgumentException("Line cannot have points overlap")
        }
        if (!getLength().isFinite()) {
            throw IllegalArgumentException("Points are too far apart, line length must be less than ${Double.MAX_VALUE}")
        }
    }
    fun getSlope():Double{
        val a: Point = definingPoints[0]
        val b: Point = definingPoints[1]
        if (a.getX()==b.getX()){
            return Double.NaN
        }
        val slope: Double = (b.getY()-a.getY())/(b.getX()-a.getX())
        if (slope.isFinite()){
            return slope
        }
        else{
            return Double.NaN
        }
    }
    fun getLength():Double{
        val a: Point = definingPoints[0]
        val b: Point = definingPoints[1]
        var dx=abs(b.getX()-a.getX())
        var dy=abs(b.getY()-a.getY())
        val scale= if(dx>dy){dx}else{dy}
        dx /= scale
        dy /= scale
        return sqrt(dx * dx + dy * dy)*scale
    }
    fun getEndPoints(): List<Point>{
        return getPoints()
    }
}