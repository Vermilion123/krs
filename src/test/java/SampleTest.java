import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Renat on 05.07.2016.
 */
@RunWith(JUnit4.class)
public class SampleTest {
    @Test(expected = IndexOutOfBoundsException.class)
    public void collectionTest() {
        List s = new ArrayList();
        s.get(0);
    }
}
