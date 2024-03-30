import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestUtil {
  private Util util;

  @Before
  public void setUp() {
    util = new Util();
  }

  @Test
  public void example() {
    assertTrue(true);
  }

  @Test
  public void testComputeSingleArg() {
    assertFalse(util.compute(1));
  }

  @Test
  public void testComputeEvenArgs() {
    assertFalse(util.compute(1, 2));
  }

  @Test
  public void testComputeOddArgsSumNotDivisible() {
    assertFalse(util.compute(2, 2, 3));
  }

  @Test
  public void testComputeOddArgsSumDivisible() {
    assertTrue(util.compute(2, 4, -6));
  }

  @Test(expected = RuntimeException.class)
  public void testComputeWithZero() {
    util.compute(0, 0, 0);
  }

}