package no.jansenh.netex.domain;

import java.util.Date;

/**
 * <em>AvailabilityCondition domain object.</em>
 *
 * <p>NeTEx version =1.15:NO-NeTEx-networktimetable:1.5
 *
 * @since 0.1.0 2024-12-23
 * @author <a href="mailto:henningzen@jansenh.no">Henning Jansen</a>
 * @version 0.1.0 2024-12-23
 */
public class AvailabilityCondition {

  public record AvailabilityConditionRecord(String version, String id, Date fromDate, Date toDate) {
    private AvailabilityConditionRecord(Builder builder) {
      this(builder.version, builder.id, builder.fromDate, builder.toDate);
    }

    public static class Builder {
      private String version = null;
      private String id = null;
      private Date fromDate = null;
      private Date toDate = null;

      public void setVersion(String version) {
        this.version = version;
      }

      public void setId(String id) {
        this.id = id;
      }

      public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
      }

      public void setToDate(Date toDate) {
        this.toDate = toDate;
      }

      public AvailabilityConditionRecord build() {
        return new AvailabilityConditionRecord(this);
      }
    }
  }
}
