abstract class Shape (definingPointsInput: List<Point>){
    protected var definingPoints: List<Point> = definingPointsInput.map{it.clone()}
    protected abstract fun validateDimensions()
    protected fun getPoints(): List<Point>{
        return definingPoints.map { it.clone() }
    }
    fun move(dx: Double, dy: Double){
        if(!dx.isFinite() || !dy.isFinite()){
            throw IllegalArgumentException("Movement vector must have only finite doubles")
        }
        for (point in definingPoints){
            point.move(dx, dy)
        }
    }
}