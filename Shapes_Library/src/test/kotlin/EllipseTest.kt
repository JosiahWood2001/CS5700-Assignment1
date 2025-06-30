import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
class EllipseTest {
    @Test
    fun testEllipseCreation(){
        assertThrows<IllegalArgumentException>{Ellipse(Point(0.0,0.0),0.0,1.0)}
        assertThrows<IllegalArgumentException>{Ellipse(Point(0.0,0.0),Double.POSITIVE_INFINITY,1.0)}
        assertThrows<IllegalArgumentException>{Ellipse(Point(0.0,0.0),Double.NaN,1.0)}
        assertThrows<IllegalArgumentException>{Ellipse(Point(0.0,0.0),Double.MAX_VALUE,1.0)}
        assertDoesNotThrow{Ellipse(Point(3.0,-100.0),100.0,42.1)}
    }
    @Test
    fun testEllipseEncapsulation(){
        val pointA = Point(2.0,3.0)
        val ellipseA = Ellipse(pointA,1.0,2.0)
        assertFalse(pointA===ellipseA.getCenter())
        assertEquals(2.0,ellipseA.getCenter().getX())
        assertEquals(3.0,ellipseA.getCenter().getY())
        pointA.move(1.0,1.0)
        assertEquals(2.0,ellipseA.getCenter().getX())
        assertEquals(3.0,ellipseA.getCenter().getY())
        ellipseA.getCenter().move(1.0,1.0)
        assertEquals(2.0,ellipseA.getCenter().getX())
        assertEquals(3.0,ellipseA.getCenter().getY())
    }
    @Test
    fun testEllipseMove(){
        val ellipseA = Ellipse(Point(0.0,0.0),1.0,2.0)
        ellipseA.move(2.0,-1.0)
        assertEquals(2.0 ,ellipseA.getCenter().getX())
        assertEquals(-1.0 ,ellipseA.getCenter().getY())
        assertThrows<IllegalArgumentException>{ellipseA.move(Double.NaN,0.0)}
        assertThrows<IllegalArgumentException>{ellipseA.move(Double.POSITIVE_INFINITY,0.0)}
        assertThrows<IllegalArgumentException>{ellipseA.move(0.0,Double.NEGATIVE_INFINITY)}
        assertThrows<IllegalArgumentException>{ellipseA.move(0.0,Double.NaN)}
    }
    @Test
    fun testEllipseArea(){
        val ellipseA = Ellipse(Point(0.0,0.0),10.0,20.0)
        assertEquals(20.0*10.0*Math.PI,ellipseA.getArea())
    }
}