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

public class Individual {
  
  private String taxonCanonicalName;
  private String name;
  private long   id;
  
  public String toString() { return name; }
  public String taxonCanonicalName() { return taxonCanonicalName; }
  public long   id() { return id; }
  
  public static Map<Long,Individual> forStudy(long studyId) {
    final Map<Long, Individual> map = new HashMap<Long, Individual>();
    Movebank.get("individual","study_id="+studyId,"id,local_identifier,taxon_id",new Movebank.Parser() {
      public void parse(Map<String,String> row) {
        try {
          Individual i = new Individual();
          i.name = row.get("local_identifier");
          i.id = Long.parseLong(row.get("id"));
          String taxonId = row.get("taxon_id");
          if (i.name==null) return;
          if (taxonId!=null) i.taxonCanonicalName = Taxon.get( Long.parseLong(taxonId) ).canonicalName();
          //System.out.printf("%s: %s (%d)\n", i.name, i.taxonCanonicalName, (long) Long.parseLong(row.get("id")));
          map.put( i.id , i);
        }
        catch (NumberFormatException nfe) {
          System.err.printf("NumberFormatException for row %s\n",row);
        }
        catch (NullPointerException npe) {
          System.err.printf("NullPointerException for row %s\n",row);
        }
      }
    });
    return map;
  }

  public static void main(String[] args) {
    //forStudy(91931153);
    System.out.printf("%s\n",System.getProperty("user.home"));
    System.out.printf("%s\n",System.getProperty("user.dir"));
  }
}
