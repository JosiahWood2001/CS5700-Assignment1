class Point (
    private var x: Double,
    private var y: Double
){
    init{
        if (!x.isFinite()||!y.isFinite()){
            throw IllegalArgumentException("Point coordinates must be a finite double")
        }
    }
    fun getX(): Double = x
    fun getY(): Double = y
    fun clone(): Point = Point(x, y)
    fun move(dx: Double, dy: Double){
        if(!dx.isFinite() || !dy.isFinite()){
            throw IllegalArgumentException("Movement vector must have only finite doubles")
        }
        x += dx
        y += dy
    }
}