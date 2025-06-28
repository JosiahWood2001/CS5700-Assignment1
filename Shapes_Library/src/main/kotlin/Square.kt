import kotlin.math.abs

class Square(corner1: Point, corner2: Point):Rectangle(corner1, corner2) {
    override fun validateDimensions() {
        super.validateDimensions()
        if (abs(width)!=abs(height)){
            throw IllegalArgumentException("A square must have its width and height equal")
        }

    }
}