import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertFalse

class PointTest {
    @Test
    fun testPointCreation(){
        assertThrows<IllegalArgumentException>{
            Point(Double.NaN, 0.0)
        }
        assertThrows<IllegalArgumentException>{
            Point(Double.POSITIVE_INFINITY, 01.0)
        }
        assertDoesNotThrow { Point(48786598971.0355,-18235594.023255) }
    }
    @Test
    fun testPointMove(){
        val point = Point(1.0, 2.0)
        assertEquals(1.0,point.getX())
        assertEquals(2.0,point.getY())
        point.move(0.0,4.0)
        assertEquals(6.0,point.getY())
        assertEquals(1.0,point.getX())
        point.move(1.0,-4.0)
        assertEquals(2.0,point.getX())
        assertEquals(2.0,point.getY())
    }
    @Test
    fun testPointCloning(){
        val point = Point(1.0, 2.0)
        val point2 = point.clone()
        assertEquals(point.getX(),point2.getX())
        assertEquals(point.getY(),point2.getY())
        point2.move(1.0,1.0)
        assertNotEquals(point.getX(),point2.getX())
        assertNotEquals(point.getY(),point2.getY())
        val point3 = point2.clone()
        assertFalse(point3===point2)
    }
}