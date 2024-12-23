package no.jansenh.netex.parser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.Map;
import no.jansenh.netex.Utilities;
import org.junit.jupiter.api.Test;

public class ParserTest {

  private final Map<String, String> testFiles = Utilities.getInstance().getXmlFiles();

  @Test
  void testParse() {

    Parser parser = new Parser(new File(testFiles.get("SOF_292")));
    parser.parse();

    var publicationDeliveryRecord = parser.getPublicationDeliveryRecord();
    assertThat(publicationDeliveryRecord.version(), equalTo("1.15:NO-NeTEx-networktimetable:1.5"));
    assertThat(publicationDeliveryRecord.participantRef(), equalTo("RB"));
    assertThat(publicationDeliveryRecord.publicationTimestamp(), is(notNullValue()));
    System.out.printf("NetworkTimetable::PublicationDelivery: %s\n", publicationDeliveryRecord);

    var compositeFrameRecord = parser.getCompositeFrameRecord();
    System.out.printf("NetworkTimetable::CompositeFrame: %s\n", compositeFrameRecord);

    var availabilityConditionRecord = parser.getAvailabilityConditionRecord();
    System.out.printf("NetworkTimetable::AvailabilityCondition: %s\n", availabilityConditionRecord);

    System.out.printf("Codespaces: %s\n", parser.getCodespaces());
  }
}
