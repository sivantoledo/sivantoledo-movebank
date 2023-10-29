package sivantoledo.movebank;

import java.util.HashMap;
import java.util.Map;

/*
 * Output attributes: 
 * access_profile_id, 
 * comments, 
 * death_comments, 
 * default_profile_eventdata_id, 
 * earliest_date_born, exact_date_of_birth, latest_date_born, 
 * external_id, external_id_namespace_id, 
 * i_am_owner, 
 * id, 
 * local_identifier, 
 * ring_id, 
 * sex, 
 * study_id, 
 * taxon_canonical_name, taxon_id
 */

public class Taxon {
  
  private String canonicalName;
  public String canonicalName() { return canonicalName; }
  
  private static Map<Long,Taxon> map = new HashMap<Long,Taxon>();
  
  public static Taxon get(final long id) {
    Taxon t = map.get(id);
    if (t!=null) return t;
    
    //System.out.printf("reading taxon from movebank\n");
    Movebank.get("taxon","id="+id,"canonical_name",new Movebank.Parser() {
      public void parse(Map<String,String> row) {
        Taxon t = new Taxon();
        t.canonicalName = row.get("canonical_name");
        map.put(id, t);
      }
    });
    return map.get(id);
  }

}
