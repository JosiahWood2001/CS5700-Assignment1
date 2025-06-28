class Circle(center: Point, radiusX: Double, radiusY: Double
):Ellipse(center,radiusX,radiusY){
    override fun validateDimensions() {
        super.validateDimensions()
        if (radiusX!=radiusY){
            throw IllegalArgumentException("A circle must have the same radiusX and radiusY")
        }
    }
}