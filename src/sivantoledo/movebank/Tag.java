package sivantoledo.movebank;

import java.util.HashMap;
import java.util.Map;

/*
 * Output attributes: 
 * access_profile_id, 
 * beacon_frequency, 
 * comments, 
 * external_id, external_id_namespace_id, 
 * i_am_owner, 
 * id, 
 * local_identifier, 
 * manufacturer_name, model, serial_no, 
 * processing_type, 
 * study_id, 
 * tag_failure_comments, 
 * tag_production_date, 
 * tag_type_id, 
 * weight
 */

public class Tag {
  
  private long   id;
  private String name;
  private String manufacturer;
  private String model;
  private String serial;
  
  public long   id()   { return id; }
  public String name() { return name; }
  public String toString() { return name; }
  public String manufacturer() { return manufacturer; }
  public String model() { return model; }
  public String serial() { return serial; }
  
  public static Map<Long,Tag> forStudy(long studyId) {
    final Map<Long, Tag> map = new HashMap<Long, Tag>();
    Movebank.get("tag","study_id="+studyId,"id,local_identifier,tag_type_id,manufacturer_name,model,serial_no,external_id",new Movebank.Parser() {
      public void parse(Map<String,String> row) {
        //System.out.printf("tag: %s\n", row);
        Tag i = new Tag();
        i.id   = Long.parseLong( row.get("id") );
        i.name = row.get("local_identifier");
        i.manufacturer = row.get("manufacturer_name");
        i.model        = row.get("model");
        i.serial       = row.get("serial_no");
        //String taxonId = row.get("taxon_id");
        if (i.name==null) return;
        //if (taxonId!=null) i.taxonCanonicalName = Taxon.get( Long.parseLong(taxonId) ).canonicalName();
        //System.out.printf("tag %s: \n", i.name);
        map.put( Long.parseLong(row.get("id")), i); 
      }
    });
    return map;
  }

  public static void main(String[] args) {
    forStudy(91931153);
  }
}
