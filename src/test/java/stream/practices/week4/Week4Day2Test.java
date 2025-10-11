package stream.practices.week4;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author PhatNguyen
 * @created 11/10/2025 - 21:50
 * @project java-stream-exercises
 */
public class Week4Day2Test {

  // Test flatMap with sentences
  final static List<String> sentences = List.of("Java is fun", "Streams are powerful");
  final static List<String> sentencesWithSpaces = List.of(
      "   Java is    fun",
      "Stream    is   powerful"
  );
  final static List<String> emptySentences = List.of();

  @Test
  @DisplayName("should flatten sentences into words")
  void testFlattenSentences() {
    assertEquals(
        List.of("Java", "is", "fun", "Streams", "are", "powerful"),
        Week4Day2.flattenSentences(sentences)
    );
  }

  @Test
  @DisplayName("should flatten sentences with extra spaces into words")
  void testFlattenSentencesWithSpaces() {
    assertEquals(
        List.of("Java", "is", "fun", "Stream", "is", "powerful"),
        Week4Day2.flattenSentences(sentencesWithSpaces)
    );
  }

  @Test
  @DisplayName("should return empty list when input is empty")
  void testFlattenEmptySentences() {
    assertEquals(List.of(), Week4Day2.flattenSentences(emptySentences));
  }

  @Test
  @DisplayName("should return empty list when input is null")
  void testFlattenNullSentences() {
    assertEquals(List.of(), Week4Day2.flattenSentences(null));
  }


}
