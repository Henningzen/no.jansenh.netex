package no.jansenh.netex.parser;

import no.jansenh.netex.domain.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import java.io.File;

/**
 * <em>Parser</em>
 *
 * <p>Parser implementation for NeTEx version =1.15:NO-NeTEx-networktimetable:1.5</p>
 *
 * @since 0.1.0 2024-12-22
 * @author <a href="mailto:henningzen@jansenh.no">Henning Jansen</a>
 * @version 0.1.0 2024-12-22
 */
public class Parser {

  private final File file;

  public Parser(File file) {
    this.file = file;
  }

  public PublicationDelivery.PublicationDeliveryRecord parse() {

    var builder = new PublicationDelivery.PublicationDeliveryRecord.Builder();

    try {

      XMLInputFactory factory = XMLInputFactory.newInstance();
      FileInputStream fileInputStream = new FileInputStream(file);
      XMLStreamReader reader = factory.createXMLStreamReader(fileInputStream);

      while (reader.hasNext()) {
        int event = reader.next();


        if (event == XMLStreamConstants.START_ELEMENT) {
          String localName = reader.getLocalName();

          if (localName.equals("PublicationDelivery")) {
            // Get the "version" attribute from PublicationDelivery
            builder.setVersion(reader.getAttributeValue(null, "version"));
          }

          switch (localName) {
            case "PublicationTimestamp":
              builder.setPublicationTimestamp(
                  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(reader.getElementText()));
              break;
            case "ParticipantRef":
              builder.setParticipantRef(reader.getElementText());
              break;
            case "Description":
              builder.setDescription(reader.getElementText());
              break;
            default:
              break;
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return builder.build();
  }
}
