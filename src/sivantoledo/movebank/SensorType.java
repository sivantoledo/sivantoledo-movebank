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

public class SensorType {
  
  private String name;
  private long   id;
  private boolean isLocationSensor;
  
  public String toString() { return name; }
  public boolean isLocationSensor()      { return isLocationSensor; }
  public long    id() { return id; }
  
  private static Map<Long,SensorType> map;
  private static Map<String,Long> byName;
  
  private static Map<Long,SensorType> catalog() {
    if (map!=null) return map;
    
    map = new HashMap<Long,SensorType>();
    byName = new HashMap<String,Long>();
    
    //System.out.printf("reading sensor types from movebank\n");
    Movebank.get("tag_type",null,"is_location_sensor,name,id",new Movebank.Parser() {
      public void parse(Map<String,String> row) {
        SensorType s = new SensorType();
        s.name = row.get("name");
        s.id   = (long) Long.parseLong(row.get("id"));
        s.isLocationSensor = Boolean.parseBoolean(row.get("is_location_sensor"));
        map.put(s.id, s);
        byName.put(s.name,s.id);
        //System.out.printf("%s\n",row);
      }
    });
    
    return map;
  }
 
  public static SensorType get(long id) {
    if (map==null) catalog();
    SensorType s = map.get(id);
    return s;
  }
  
  public static SensorType get(String name) {
    if (map==null) catalog();
    return get(byName.get(name));
  }
  
  public static void main(String[] args) {
    SensorType s = get("GPS");
    System.out.printf("%d %s %b\n",s.id,s.name,s.isLocationSensor);
    //SensorType s = get("Radio Transmitter");
  }
}
