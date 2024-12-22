package no.jansenh.netex;

import java.util.HashMap;
import java.util.Map;

public class Utilities {
  
  private final Map<String, String> xmlFiles = new HashMap<>();

  private Utilities() {
    // private no-args constructor.
    xmlFiles.put("SOF_292", "src/test/resources/netex/sof-292.xml");
  }

  public static Utilities getInstance() {
    return new Utilities();
  }

  public  Map<String, String> getXmlFiles() {
    return xmlFiles;
  }
}
