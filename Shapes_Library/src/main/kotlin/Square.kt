import kotlin.math.abs

class Square(corner1: Point, corner2: Point):Rectangle(corner1, corner2) {
    init{
        validateDimensions()
    }
    override fun validateDimensions() {
        super.validateDimensions()
        if (width!=height){
            throw IllegalArgumentException("A square must have its width and height equal")
        }

    }
}