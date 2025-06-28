open class Ellipse(center: Point,
                   protected var radiusX: Double,
                   protected var radiusY: Double
):Shape(listOf(center)) {
    override fun validateDimensions(){
        if (!(radiusX > 0.0 && radiusY > 0.0)){
            throw IllegalArgumentException("The radius must be positive.")
        }
    }
    fun getRadius(): List<Double> {
        return listOf(radiusX, radiusY)
    }
    fun getArea(): Double {
        return Math.PI*radiusX*radiusY
    }
    fun getCenter(): Point{
        return getPoints().first()
    }
}