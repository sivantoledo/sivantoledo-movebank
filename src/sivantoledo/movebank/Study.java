package sivantoledo.movebank;

/*
 * Output attributes: 
 * access_profile_download_id, access_profile_id, 
 * acknowledgements, citation, comments, grants_used, 
 * study_objective, study_type, 
 * license_terms, suspend_license_terms, 
 * bounding_box, location_description, main_location_lat, main_location_long, 
 * contact_person_id, 
 * principal_investigator_address, principal_investigator_email, principal_investigator_id, principal_investigator_name, 
 * has_quota, 
 * default_profile_eventdata_id, default_profile_refdata_id, 
 * external_id, external_id_namespace_id, 
 * i_am_owner, i_can_see_data, there_are_data_which_i_cannot_see, 
 * id, name, 
 * study_id, 
 * OBSOLETE FROM HERE ON
 * number_of_deployments, 
 * number_of_events, 
 * number_of_individuals, 
 * number_of_tags, 
 * timestamp_end, timestamp_start
 */

import java.util.HashMap;
import java.util.Map;

import sivantoledo.util.TimeStrings;

public class Study {
  
  private String name;
  private long   id;
  private double mainLocationLat = Double.NaN;
  private double mainLocationLon = Double.NaN;
  private double timestampFirstDeployedLocation = Double.NaN;
  private double timestampLastDeployedLocation  = Double.NaN;
  
  private Map<Long,Individual> individuals;
  private Map<Long,Deployment> deployments;
  private Map<Long,Tag>        tags;
  
  public String toString() { return name; }
  public double lat()      { return mainLocationLat; }
  public double lon()      { return mainLocationLon; }
  public double startTime() { return timestampFirstDeployedLocation; }
  public double endTime()   { return timestampLastDeployedLocation; }
  public Map<Long,Individual> individuals() { return individuals; }
  public Map<Long,Deployment> deployments() { return deployments; }
  public Map<Long,Tag>        tags()        { return tags; }
  public long id()         { return id; }
  
  private static Map<Long,Study> map;
  private static Map<String,Long> byName;
  
  public static Map<Long,Study> catalog(final boolean onlyIfICanSeeData) {
    if (map!=null) return map;
    
    map = new HashMap<Long,Study>();
    byName = new HashMap<String,Long>();
    
    //System.out.printf("reading studies from movebank...\n");
    int rc = Movebank.get("study",onlyIfICanSeeData ? "i_can_see_data=true" : null,
                          "id,name,i_can_see_data",
                          new Movebank.Parser() {
      public void parse(Map<String,String> row) {
        if (!onlyIfICanSeeData || row.get("i_can_see_data").equals("true")) {
          Study s = new Study();
          s.name = row.get("name");
          s.id   = (long) Long.parseLong(row.get("id"));
          map.put(s.id, s);
          byName.put(s.name,s.id);
          //System.out.printf("%s ==> %d\n",s,s.id);
        }
      }
    });
    
    if (rc==-1) { // failure
      map = null;
      byName = null;
      throw new MovebankReader.LicenseException("Could not retrieve even list of studies");
    }
    
    return map;
  }
 
  public static Study get(long id) {
    if (map==null) catalog(false);
    Study s = map.get(id);
    if (s==null) return s;
    if (s.individuals==null) {
      s.individuals = Individual.forStudy(s.id);
      s.deployments = Deployment.forStudy(s.id);
      s.tags        = Tag.forStudy(s.id);
      final Study sfinal = s;
      //System.out.printf("reading studies from movebank\n");
      Movebank.get("study","study_id="+id,
                   // Sivan September 2020, removed fields that are not longer in MB (and were not used)
                   //"id,name,location_description,main_location_lat,main_location_long,timestamp_end,timestamp_start",
                   "id,name,study_objective,main_location_lat,main_location_long,timestamp_last_deployed_location,timestamp_first_deployed_location",
                   new Movebank.Parser() {
        public void parse(Map<String,String> row) {
            if (row.containsKey("main_location_lat")) {
              sfinal.mainLocationLat = Double.parseDouble(row.get("main_location_lat"));
              sfinal.mainLocationLon = Double.parseDouble(row.get("main_location_long"));
              sfinal.timestampFirstDeployedLocation = TimeStrings.parseTime("yyyy-MM-dd HH:mm:ss.SSS", row.get("timestamp_first_deployed_location"));
              sfinal.timestampLastDeployedLocation  = TimeStrings.parseTime("yyyy-MM-dd HH:mm:ss.SSS", row.get("timestamp_last_deployed_location"));
              System.out.printf("times = %s to %s\n", 
                  row.get("timestamp_first_deployed_location"),
                  row.get("timestamp_last_deployed_location"));
            }
            //System.out.printf("full details: %s\n",row);
          }
        });
    }
    return s;
  }
  
  public static Study get(String name) {
    if (map==null) catalog(false);
    //System.out.printf("getting from %s study %s number %s\n", byName, name, byName.get(name));
    //if (byName==null) throw new MovebankReader.LicenseException("Could not even retrieve catalog of studies");
    //System.err.printf("name = [%s]\n",name);
    return get(byName.get(name));
  }
  
  public static void main(String[] args) {
    get(91931153);
  }
}
