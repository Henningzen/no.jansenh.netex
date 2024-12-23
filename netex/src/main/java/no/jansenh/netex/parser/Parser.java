package no.jansenh.netex.parser;

import no.jansenh.netex.domain.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <em>Parser</em>
 *
 * <p>Parser implementation for NeTEx version =1.15:NO-NeTEx-networktimetable:1.5</p>
 *
 * <p>
 *   <em>Known limitations</em>
 *   <ul>
 *     <li>Not properly tested.</li>
 *     <li>Logging not provided.</li>
 *   </ul>
 * </p>
 *
 * @since 0.1.0 2024-12-22
 * @author <a href="mailto:henningzen@jansenh.no">Henning Jansen</a>
 * @version 0.1.0 2024-12-22
 */
public class Parser {

  private final File file;
  private PublicationDelivery.PublicationDeliveryRecord publicationDeliveryRecord;
  private CompositeFrame.CompositeFrameRecord compositeFrameRecord;
  private AvailabilityCondition.AvailabilityConditionRecord availabilityConditionRecord;
  private final List<String> codespaces = new ArrayList<>();

  public PublicationDelivery.PublicationDeliveryRecord getPublicationDeliveryRecord() {
    return publicationDeliveryRecord;
  }

  public CompositeFrame.CompositeFrameRecord getCompositeFrameRecord() {
    return compositeFrameRecord;
  }

  public AvailabilityCondition.AvailabilityConditionRecord getAvailabilityConditionRecord() {
    return availabilityConditionRecord;
  }

  public List<String> getCodespaces() {
    return codespaces;
  }

  public Parser(File file) {
    this.file = file;
  }

  public void parse() {

    var publicationDeliveryBuilder = new PublicationDelivery.PublicationDeliveryRecord.Builder();
    var compositeFrameBuilder = new CompositeFrame.CompositeFrameRecord.Builder();
    var availabilityCondition = new AvailabilityCondition.AvailabilityConditionRecord.Builder();

    try {

      XMLInputFactory factory = XMLInputFactory.newInstance();
      FileInputStream fileInputStream = new FileInputStream(file);
      XMLStreamReader reader = factory.createXMLStreamReader(fileInputStream);

      while (reader.hasNext()) {
        int event = reader.next();

        if (event == XMLStreamConstants.START_ELEMENT) {
          String localName = reader.getLocalName();

          switch (localName) {
            case "PublicationDelivery":
              publicationDeliveryBuilder.setVersion(reader.getAttributeValue(null, "version"));
              break;
            case "PublicationTimestamp":
              publicationDeliveryBuilder.setPublicationTimestamp(
                  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(reader.getElementText()));
              break;
            case "ParticipantRef":
              publicationDeliveryBuilder.setParticipantRef(reader.getElementText());
              break;
            case "Description":
              publicationDeliveryBuilder.setDescription(reader.getElementText());
              break;
            case "CompositeFrame":
              compositeFrameBuilder.setId(reader.getAttributeValue(null, "id"));
              compositeFrameBuilder.setCreated(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(reader.getAttributeValue(null, "created")));
              compositeFrameBuilder.setVersion(reader.getAttributeValue(null, "version"));
              break;
            case "AvailabilityCondition":
              availabilityCondition.setId(reader.getAttributeValue(null, "id"));
              availabilityCondition.setVersion(reader.getAttributeValue(null, "version"));
              break;
            case "FromDate":
              availabilityCondition.setFromDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(reader.getElementText()));
              break;
            case "ToDate":
              availabilityCondition.setToDate(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(reader.getElementText()));
              break;
            case "Codespace":
              codespaces.add(reader.getAttributeValue(null, "id"));
            default:
              break;
            }
          }
        }

    } catch (Exception e) {
      e.printStackTrace();
    }
    this.publicationDeliveryRecord = publicationDeliveryBuilder.build();
    this.compositeFrameRecord = compositeFrameBuilder.build();
    this.availabilityConditionRecord = availabilityCondition.build();
  }
}