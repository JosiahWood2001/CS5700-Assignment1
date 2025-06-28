abstract class Shape (definingPointsInput: List<Point>){
    protected var definingPoints: List<Point> = definingPointsInput.map{it.clone()}

    abstract fun validateDimensions()
    protected fun getPoints(): List<Point>{
        return definingPoints.map { it.clone() }
    }
    fun move(dx: Double, dy: Double){
        for (point in definingPoints){
            point.move(dx, dy)
        }
    }
}