package no.jansenh.netex.domain;

import java.util.Date;

/**
 * <em>PublicationDelivery domain object.</em>
 *
 * <p>NeTEx version =1.15:NO-NeTEx-networktimetable:1.5</p>
 *
 * @since 0.1.0 2024-12-22
 * @author <a href="mailto:henningzen@jansenh.no">Henning Jansen</a>
 * @version 0.1.0 2024-12-22
 */
public class PublicationDelivery {

  public record PublicationDeliveryRecord(
      String version,
      Date publicationTimestamp,
      String participantRef,
      String description
  ) {
      private PublicationDeliveryRecord(Builder builder) {
      this(
          builder.version,
          builder.publicationTimestamp,
          builder.participantRef,
          builder.description
      );
    }

    public static class Builder {
      private String version = null;
      private Date publicationTimestamp = null;
      private String participantRef = null;
      private String description = null;

      // Fluent setters
      public void setVersion(String version) {
        this.version = version;
      }

      public void setPublicationTimestamp(Date publicationTimestamp) {
        this.publicationTimestamp = publicationTimestamp;
      }

      public void setParticipantRef(String participantRef) {
        this.participantRef = participantRef;
      }

      public void setDescription(String description) {
        this.description = description;
      }

      public PublicationDeliveryRecord build() {
        return new PublicationDeliveryRecord(this);
      }
    }
  }
}
