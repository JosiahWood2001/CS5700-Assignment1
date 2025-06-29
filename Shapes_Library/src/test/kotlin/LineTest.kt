import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
class LineTest {
    @Test
    fun testLineCreation(){
        assertThrows<IllegalArgumentException>{Line(Point(1.3,2.4),Point(1.3,2.4))}
        assertDoesNotThrow{Line(Point(1.3,2.4),Point(1.3,2.4000001))}
        assertDoesNotThrow{Line(Point(1.3,2.4),Point(1.3000001,2.4))}
    }
    @Test
    fun testLineEncapsulation(){
        val pointA = Point(0.0,0.0)
        val pointB = Point(1.0,1.0)
        val lineA = Line(pointA, pointB)
        assertFalse(pointA===lineA.getEndPoints()[0])
        assertFalse(pointB===lineA.getEndPoints()[1])
        assertEquals(0.0,lineA.getEndPoints()[0].getX())
        assertEquals(0.0,lineA.getEndPoints()[0].getY())
        assertEquals(1.0,lineA.getEndPoints()[1].getX())
        assertEquals(1.0,lineA.getEndPoints()[1].getY())
        pointA.move(1.0,1.0)
        pointB.move(1.0,1.0)
        assertEquals(0.0,lineA.getEndPoints()[0].getX())
        assertEquals(0.0,lineA.getEndPoints()[0].getY())
        assertEquals(1.0,lineA.getEndPoints()[1].getX())
        assertEquals(1.0,lineA.getEndPoints()[1].getY())
        lineA.getEndPoints()[0].move(1.0,1.0)
        lineA.getEndPoints()[1].move(1.0,1.0)
        assertEquals(0.0,lineA.getEndPoints()[0].getX())
        assertEquals(0.0,lineA.getEndPoints()[0].getY())
        assertEquals(1.0,lineA.getEndPoints()[1].getX())
        assertEquals(1.0,lineA.getEndPoints()[1].getY())
    }
    @Test
    fun testLineMove(){
        val lineA = Line(Point(0.0,0.0), Point(1.0,1.0))
        lineA.move(2.0,-1.0)
        assertEquals(2.0 ,lineA.getEndPoints()[0].getX())
        assertEquals(-1.0 ,lineA.getEndPoints()[0].getY())
        assertEquals(3.0,lineA.getEndPoints()[1].getX())
        assertEquals(0.0,lineA.getEndPoints()[1].getY())
        assertThrows<IllegalArgumentException>{lineA.move(Double.NaN,0.0)}
        assertThrows<IllegalArgumentException>{lineA.move(Double.POSITIVE_INFINITY,0.0)}
        assertThrows<IllegalArgumentException>{lineA.move(0.0,Double.NEGATIVE_INFINITY)}
        assertThrows<IllegalArgumentException>{lineA.move(0.0,Double.NaN)}
    }
    @Test
    fun testLineLength(){
        val lineA = Line(Point(0.0,0.0),Point(3.0,4.0))
        val lineB = Line(Point(0.0,0.0),Point(Double.MAX_VALUE/20,Double.MAX_VALUE/15))
        assertThrows<IllegalArgumentException>{Line(Point(Double.MAX_VALUE,0.0),Point(0.0,Double.MAX_VALUE))}
        assertThrows<IllegalArgumentException>{Line(Point(Double.MAX_VALUE,0.0),Point(-Double.MAX_VALUE,0.0))}
        assertDoesNotThrow{Line(Point(1.797693134862315E308,0.0),Point(0.0,0.0))}
        assertThrows<IllegalArgumentException>{Line(Point(Double.MAX_VALUE,0.0),Point(0.0,Double.MAX_VALUE/1e5))}
        assertEquals(5.0,lineA.getLength())
        assertEquals(Double.MAX_VALUE/12,lineB.getLength())
    }
    @Test
    fun testLineSlope(){
        val lineA = Line(Point(0.0,0.0),Point(100.0,0.0))
        val lineB = Line(Point(0.0,10.0), Point(0.0,-1000.0))
        val lineC = Line(Point(0.0,0.0),Point(1e-100,1.797693134862315E308))
        val lineD = Line(Point(0.0,0.0),Point(-10.0,10.0))
        val lineE = Line(Point(0.0,0.0),Point(10.0,2.0))
        assertEquals(0.0,lineA.getSlope())
        assertEquals(Double.NaN,lineB.getSlope())
        assertEquals(Double.POSITIVE_INFINITY,lineC.getSlope())
        assertEquals(-1.0,lineD.getSlope())
        assertEquals(0.2,lineE.getSlope())
    }
}