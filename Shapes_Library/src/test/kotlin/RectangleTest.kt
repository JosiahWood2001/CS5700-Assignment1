import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
class RectangleTest {
    @Test
    fun testRectangleCreation(){
        assertThrows<IllegalArgumentException>{Rectangle(Point(0.0,1.0),Point(0.0,3.0))}
        assertThrows<IllegalArgumentException>{Rectangle(Point(0.0,1.0),Point(6.0,1.0))}
        assertThrows<IllegalArgumentException>{Rectangle(Point(Double.MAX_VALUE,1.0),Point(0.0,3.0))}
        assertDoesNotThrow{Rectangle(Point(-1.0,1.0),Point(0.0,3.0))}
    }
    @Test
    fun testRectangleEncapsulation(){
        val pointA = Point(2.0,3.0)
        val pointB = Point(4.0,8.0)
        val rectA = Rectangle(pointA,pointB)
        assertFalse(pointA===rectA.getCorners()[0])
        assertFalse(pointB===rectA.getCorners()[1])
        assertEquals(2.0,rectA.getCorners()[0].getX())
        assertEquals(3.0,rectA.getCorners()[0].getY())
        assertEquals(4.0,rectA.getCorners()[1].getX())
        assertEquals(8.0,rectA.getCorners()[1].getY())
        pointA.move(1.0,1.0)
        pointB.move(1.0,1.0)
        assertEquals(2.0,rectA.getCorners()[0].getX())
        assertEquals(3.0,rectA.getCorners()[0].getY())
        assertEquals(4.0,rectA.getCorners()[1].getX())
        assertEquals(8.0,rectA.getCorners()[1].getY())
        rectA.getCorners()[0].move(1.0,1.0)
        rectA.getCorners()[1].move(1.0,1.0)
        assertEquals(2.0,rectA.getCorners()[0].getX())
        assertEquals(3.0,rectA.getCorners()[0].getY())
        assertEquals(4.0,rectA.getCorners()[1].getX())
        assertEquals(8.0,rectA.getCorners()[1].getY())
    }
    @Test
    fun testRectangleMove(){
        val rectA = Rectangle(Point(0.0,0.0),Point(1.0,2.0))
        rectA.move(2.0,-1.0)
        assertEquals(2.0 ,rectA.getCorners()[0].getX())
        assertEquals(-1.0 ,rectA.getCorners()[0].getY())
        assertThrows<IllegalArgumentException>{rectA.move(Double.NaN,0.0)}
        assertThrows<IllegalArgumentException>{rectA.move(Double.POSITIVE_INFINITY,0.0)}
        assertThrows<IllegalArgumentException>{rectA.move(0.0,Double.NEGATIVE_INFINITY)}
        assertThrows<IllegalArgumentException>{rectA.move(0.0,Double.NaN)}
    }
    @Test
    fun testRectangleArea(){
        val pointA = Point(-10.0,20.0)
        val pointB = Point(-20.0,10.0)
        val rectA = Rectangle(pointA,pointB)
        val rectB = Rectangle(pointB,pointA)
        assertEquals(100.0,rectA.getArea())
        assertEquals(100.0,rectB.getArea())
    }
}