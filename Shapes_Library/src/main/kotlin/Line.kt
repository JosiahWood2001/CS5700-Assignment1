class Line(a: Point, b: Point) : Shape(listOf(a,b)){
    override fun validateDimensions(){
        val a: Point = definingPoints[0]
        val b: Point = definingPoints[1]
        if (a.getX()==b.getX()&&a.getY()==b.getY()){
            throw IllegalArgumentException("Line cannot have points overlap")
        }
    }
    fun slope():Double{
        val a: Point = definingPoints[0]
        val b: Point = definingPoints[1]
        if (a.getX()==b.getX()){
            return Double.NaN
        }
        return (b.getY()-a.getY())/(b.getX()-a.getX())
    }
}