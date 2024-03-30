import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestCompute {
  private Compute c;
  private MessageQueue mq;

  @Before
  public void setUp() {
    mq = mock(MessageQueue.class);
    c = new Compute(mq);
  }

  @Test
  public void testCountWithEmptyQueue() {
    when(mq.size()).thenReturn(0);
    assertEquals(-1, c.countNumberOfOccurrences("element"));
  }

  @Test
  public void testCountWithElementNotPresent() {
    when(mq.size()).thenReturn(1);
    when(mq.contains("element")).thenReturn(false);
    assertEquals(0, c.countNumberOfOccurrences("element"));
  }

  @Test
  public void testCountWithElementPresentOnce() {
    when(mq.size()).thenReturn(1);
    when(mq.contains("element")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("element");
    assertEquals(1, c.countNumberOfOccurrences("element"));
  }

  @Test
  public void testCountWithElementPresentMultipleTimes() {
    when(mq.size()).thenReturn(3);
    when(mq.contains("element")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("element");
    when(mq.getAt(1)).thenReturn("another");
    when(mq.getAt(2)).thenReturn("element");
    assertEquals(2, c.countNumberOfOccurrences("element"));
  }
}