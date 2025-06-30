import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
class SquareTest {
    @Test
    fun testSquareCreation(){
        assertThrows<IllegalArgumentException>{Square(Point(0.0,1.0),Point(0.0,3.0))}
        assertThrows<IllegalArgumentException>{Square(Point(0.0,1.0),Point(6.0,1.0))}
        assertThrows<IllegalArgumentException>{Square(Point(Double.MAX_VALUE,1.0),Point(0.0,3.0))}
        assertThrows<IllegalArgumentException>{Square(Point(-1.0,1.0),Point(0.0,3.0))}
        assertDoesNotThrow{Square(Point(0.0,0.0),Point(10.0,-10.0))}
    }
    @Test
    fun testSquareEncapsulation(){
        val pointA = Point(2.0,3.0)
        val pointB = Point(4.0,5.0)
        val squareA = Square(pointA,pointB)
        assertFalse(pointA===squareA.getCorners()[0])
        assertFalse(pointB===squareA.getCorners()[1])
        assertEquals(2.0,squareA.getCorners()[0].getX())
        assertEquals(3.0,squareA.getCorners()[0].getY())
        assertEquals(4.0,squareA.getCorners()[1].getX())
        assertEquals(5.0,squareA.getCorners()[1].getY())
        pointA.move(1.0,1.0)
        pointB.move(1.0,1.0)
        assertEquals(2.0,squareA.getCorners()[0].getX())
        assertEquals(3.0,squareA.getCorners()[0].getY())
        assertEquals(4.0,squareA.getCorners()[1].getX())
        assertEquals(5.0,squareA.getCorners()[1].getY())
        squareA.getCorners()[0].move(1.0,1.0)
        squareA.getCorners()[1].move(1.0,1.0)
        assertEquals(2.0,squareA.getCorners()[0].getX())
        assertEquals(3.0,squareA.getCorners()[0].getY())
        assertEquals(4.0,squareA.getCorners()[1].getX())
        assertEquals(5.0,squareA.getCorners()[1].getY())
    }
    @Test
    fun testSquareMove(){
        val squareA = Square(Point(0.0,0.0),Point(2.0,2.0))
        squareA.move(2.0,-1.0)
        assertEquals(2.0 ,squareA.getCorners()[0].getX())
        assertEquals(-1.0 ,squareA.getCorners()[0].getY())
        assertThrows<IllegalArgumentException>{squareA.move(Double.NaN,0.0)}
        assertThrows<IllegalArgumentException>{squareA.move(Double.POSITIVE_INFINITY,0.0)}
        assertThrows<IllegalArgumentException>{squareA.move(0.0,Double.NEGATIVE_INFINITY)}
        assertThrows<IllegalArgumentException>{squareA.move(0.0,Double.NaN)}
    }
    @Test
    fun testSquareArea(){
        val pointA = Point(-10.0,-20.0)
        val pointB = Point(20.0,10.0)
        val squareA = Square(pointA,pointB)
        val squareB = Square(pointB,pointA)
        assertEquals(900.0,squareA.getArea())
        assertEquals(900.0,squareB.getArea())
    }
}