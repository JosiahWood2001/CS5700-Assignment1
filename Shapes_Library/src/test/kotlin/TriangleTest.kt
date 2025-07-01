import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
class TriangleTest {
    @Test
    fun testTriangleCreation(){
        assertThrows<IllegalArgumentException>{Triangle(Point(0.0,1.0),Point(1.0,3.0),Point(2.0,5.0))}
        assertThrows<IllegalArgumentException>{Triangle(Point(0.0,1.0),Point(6.0,1.0),Point(6.0,1.0))}
        assertThrows<IllegalArgumentException>{Triangle(Point(Double.MAX_VALUE,1.0),Point(0.0,3.0),Point(0.0,Double.MAX_VALUE))}
        assertDoesNotThrow{Triangle(Point(-1.0,1.0),Point(0.0,3.0),Point(0.0,5.0))}
    }
    @Test
    fun testTriangleEncapsulation(){
        val pointA = Point(2.0,3.0)
        val pointB = Point(4.0,8.0)
        val pointC = Point(3.0,1.0)
        val triangleA = Triangle(pointA,pointB,pointC)
        assertFalse(pointA===triangleA.getCorners()[0])
        assertFalse(pointB===triangleA.getCorners()[1])
        assertFalse(pointC===triangleA.getCorners()[2])
        assertEquals(2.0,triangleA.getCorners()[0].getX())
        assertEquals(3.0,triangleA.getCorners()[0].getY())
        assertEquals(4.0,triangleA.getCorners()[1].getX())
        assertEquals(8.0,triangleA.getCorners()[1].getY())
        assertEquals(3.0,triangleA.getCorners()[2].getX())
        assertEquals(1.0,triangleA.getCorners()[2].getY())
        pointA.move(1.0,1.0)
        pointB.move(1.0,1.0)
        assertEquals(2.0,triangleA.getCorners()[0].getX())
        assertEquals(3.0,triangleA.getCorners()[0].getY())
        assertEquals(4.0,triangleA.getCorners()[1].getX())
        assertEquals(8.0,triangleA.getCorners()[1].getY())
        assertEquals(3.0,triangleA.getCorners()[2].getX())
        assertEquals(1.0,triangleA.getCorners()[2].getY())
        triangleA.getCorners()[0].move(1.0,1.0)
        triangleA.getCorners()[1].move(1.0,1.0)
        assertEquals(2.0,triangleA.getCorners()[0].getX())
        assertEquals(3.0,triangleA.getCorners()[0].getY())
        assertEquals(4.0,triangleA.getCorners()[1].getX())
        assertEquals(8.0,triangleA.getCorners()[1].getY())
        assertEquals(3.0,triangleA.getCorners()[2].getX())
        assertEquals(1.0,triangleA.getCorners()[2].getY())
    }
    @Test
    fun testTriangleMove(){
        val triangleA = Triangle(Point(0.0,0.0),Point(1.0,2.0),Point(4.0,1.0))
        triangleA.move(2.0,-1.0)
        assertEquals(2.0 ,triangleA.getCorners()[0].getX())
        assertEquals(-1.0 ,triangleA.getCorners()[0].getY())
        assertThrows<IllegalArgumentException>{triangleA.move(Double.NaN,0.0)}
        assertThrows<IllegalArgumentException>{triangleA.move(Double.POSITIVE_INFINITY,0.0)}
        assertThrows<IllegalArgumentException>{triangleA.move(0.0,Double.NEGATIVE_INFINITY)}
        assertThrows<IllegalArgumentException>{triangleA.move(0.0,Double.NaN)}
    }
    @Test
    fun testTriangleArea(){
        val pointA = Point(-10.0,20.0)
        val pointB = Point(-20.0,10.0)
        val pointC = Point(-10.0,10.0)
        val pointD = Point(100.0,70.0)
        val triangleA = Triangle(pointA,pointB,pointC)
        val triangleB = Triangle(pointB,pointA, pointD)
        val triangleC = Triangle(pointC, pointD, pointA)
        val triangleD = Triangle(pointB, pointC, pointD)
        assertEquals(50.0,triangleA.getArea())
        assertEquals(300.0,triangleB.getArea())
        assertEquals(550.0,triangleC.getArea())
        assertEquals(300.0,triangleD.getArea())
    }
}