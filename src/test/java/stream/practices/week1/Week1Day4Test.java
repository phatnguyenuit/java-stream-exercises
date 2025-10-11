package stream.practices.week1;

import static stream.practices.week1.Week1Day4.callForEachWithConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author PhatNguyen
 * @created 20/09/2025 - 13:18
 * @project java-stream-exercises
 */
@ExtendWith(MockitoExtension.class)
public class Week1Day4Test {

  @Mock
  Consumer<Integer> fakeConsumer;

  @Test
  @DisplayName("should call with custom consumer")
  void testCallCustomConsumer() {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    callForEachWithConsumer(numbers, fakeConsumer);

    // Verify that the consumer's accept method was called for each integer in the list.
    for (Integer number : numbers) {
      Mockito.verify(fakeConsumer).accept(number);
    }
    // Verify that no other interactions happened with the mock.
    Mockito.verifyNoMoreInteractions(fakeConsumer);
  }
}
