import org.junit.Test;
import static org.junit.Assert.*;


public class UnitTestClass {
    @Test
    public void dayArrangeTest() throws Exception{
        ArrangeDate dateArrange = new ArrangeDate();
        int[] value ={4,4,6,8,2,-6,2,-2};
        String[] key = {"2020-01-01", "2020-01-02", "2020-01-03", "2020-01-04", "2020-01-05", "2020-01-06", "2020-01-07", "2020-01-08" };

        assertEquals("{'Mon':-6, 'Tue':2, 'Wed':2, 'Thu':4, 'Fri':6, 'Sat':8, 'Sun':2}",dateArrange.DisplayDay(key, value));
    }

}
