package no.jansenh.netex.domain;

import java.util.Date;

/**
 * <em>CompositeFrame domain object.</em>
 *
 * <p>NeTEx version =1.15:NO-NeTEx-networktimetable:1.5
 *
 * @since 0.1.0 2024-12-23
 * @author <a href="mailto:henningzen@jansenh.no">Henning Jansen</a>
 * @version 0.1.0 2024-12-23
 */
public class CompositeFrame {

  public record CompositeFrameRecord(String version, Date created, String id) {
    private CompositeFrameRecord(Builder builder) {
      this(builder.version, builder.created, builder.id);
    }

    public static class Builder {
      private String version = null;
      private Date created = null;
      private String id = null;

      public void setVersion(String version) {
        this.version = version;
      }

      public void setCreated(Date created) {
        this.created = created;
      }

      public void setId(String id) {
        this.id = id;
      }

      public CompositeFrameRecord build() {
        return new CompositeFrameRecord(this);
      }
    }
  }
}
