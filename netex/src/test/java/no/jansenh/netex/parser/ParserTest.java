package no.jansenh.netex.parser;

import no.jansenh.netex.Utilities;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ParserTest {

  private final Map<String, String > testFiles = Utilities.getInstance().getXmlFiles();

  @Test
  void testParse() {
    // Arrange
    var parser = new Parser(new File(testFiles.get("SOF_292")));

    // Act
    var record = parser.parse();
    assertThat(record.version(), equalTo("1.15:NO-NeTEx-networktimetable:1.5"));
    assertThat(record.participantRef(), equalTo("RB"));

  }
}



