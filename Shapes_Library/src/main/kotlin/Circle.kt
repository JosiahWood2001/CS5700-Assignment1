class Circle(center: Point, radius: Double
):Ellipse(center,radius,radius){
    init{
        super.validateDimensions()
    }
    override fun getRadius(): List<Double>{
        return listOf(radiusX)
    }
}