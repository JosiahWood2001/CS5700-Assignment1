import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
class CircleTest {
    @Test
    fun testCircleCreation(){
        assertThrows<IllegalArgumentException>{Circle(Point(0.0,0.0),0.0)}
        assertThrows<IllegalArgumentException>{Circle(Point(0.0,0.0),Double.POSITIVE_INFINITY)}
        assertThrows<IllegalArgumentException>{Circle(Point(0.0,0.0),Double.NaN)}
        assertThrows<IllegalArgumentException>{Circle(Point(0.0,0.0),Double.MAX_VALUE)}
        assertDoesNotThrow{Circle(Point(3.0,-100.0),100.0)}
    }
    @Test
    fun testCircleEncapsulation(){
        val pointA = Point(2.0,3.0)
        val circleA = Circle(pointA,1.0)
        assertFalse(pointA===circleA.getCenter())
        assertEquals(2.0,circleA.getCenter().getX())
        assertEquals(3.0,circleA.getCenter().getY())
        pointA.move(1.0,1.0)
        assertEquals(2.0,circleA.getCenter().getX())
        assertEquals(3.0,circleA.getCenter().getY())
        circleA.getCenter().move(1.0,1.0)
        assertEquals(2.0,circleA.getCenter().getX())
        assertEquals(3.0,circleA.getCenter().getY())
    }
    @Test
    fun testCircleMove(){
        val circleA = Circle(Point(0.0,0.0),1.0)
        circleA.move(2.0,-1.0)
        assertEquals(2.0 ,circleA.getCenter().getX())
        assertEquals(-1.0 ,circleA.getCenter().getY())
        assertThrows<IllegalArgumentException>{circleA.move(Double.NaN,0.0)}
        assertThrows<IllegalArgumentException>{circleA.move(Double.POSITIVE_INFINITY,0.0)}
        assertThrows<IllegalArgumentException>{circleA.move(0.0,Double.NEGATIVE_INFINITY)}
        assertThrows<IllegalArgumentException>{circleA.move(0.0,Double.NaN)}
    }
    @Test
    fun testCircleArea(){
        val circleA = Circle(Point(0.0,0.0),10.0)
        assertEquals(100.0*Math.PI,circleA.getArea())
    }
}