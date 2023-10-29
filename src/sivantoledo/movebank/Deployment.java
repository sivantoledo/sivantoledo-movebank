package sivantoledo.movebank;

import java.util.HashMap;
import java.util.Map;

import sivantoledo.util.TimeStrings;

//import tau.kamadata.Time;

/*
 * Output attributes: 
 *
 * individual_id, 
 * tag_id, 
 * deploy_on_latitude, deploy_on_longitude, deploy_on_person, deploy_on_timestamp, 
 * deploy_off_latitude, deploy_off_longitude, deploy_off_person, deploy_off_timestamp, 
 *
 * local_identifier, 
 * access_profile_id, 
 * animal_life_stage, 
 * animal_mass, 
 * animal_reproductive_condition, 
 * attachment_type, 
 * behavior_according_to, 
 * comments, 
 * data_processing_software, 
 * deployment_end_comments, deployment_end_type, 
 * duty_cycle, 
 * external_id, 
 * external_id_namespace_id, 
 * geolocator_calibration, geolocator_light_threshold, geolocator_sensor_comments, geolocator_sun_elevation_angle, 
 * habitat_according_to, 
 * i_am_owner, id, 
 * location_accuracy_comments, 
 * manipulation_comments, manipulation_type, 
 * partial_identifier, 
 * study_id, 
 * study_site, 
 * tag_readout_method
 */

public class Deployment {
  
  private long tagId;
  private long individualId;
  private double deployOnTime = Double.NaN;
  private double deployOffTime = Double.NaN;
  
  
  public long tagId() {
    return tagId;
  }

  public long individualId() {
    return individualId;
  }

  public double deployOnTime() {
    return deployOnTime;
  }

  public double deployOffTime() {
    return deployOffTime;
  }

  public static Map<Long,Deployment> forStudy(long studyId) {
    final Map<Long, Deployment> map = new HashMap<Long, Deployment>();
    Movebank.get("deployment","study_id="+studyId,"id,individual_id,tag_id,deploy_on_timestamp,deploy_off_timestamp",new Movebank.Parser() {
      public void parse(Map<String,String> row) {
        //System.out.printf("deployment: %s\n", row);
        Deployment i = new Deployment();
        i.tagId        = Long.parseLong( row.get("tag_id") );
        i.individualId = Long.parseLong( row.get("individual_id") );
        String ont = row.get("deploy_on_timestamp");
        if (ont!=null) i.deployOnTime = TimeStrings.parseTime("yyyy-MM-dd HH:mm:ss.SSS", ont);
        String offt = row.get("deploy_off_timestamp");
        if (offt!=null) i.deployOffTime = TimeStrings.parseTime("yyyy-MM-dd HH:mm:ss.SSS", offt);
        //System.out.printf("deplyoment %d-%d from %f to %f\n", i.tagId, i.individualId, i.deployOnTime, i.deployOffTime);
        map.put( Long.parseLong(row.get("id")), i); 
      }
    });
    return map;
  }

  public static void main(String[] args) {
    forStudy(91931153);
  }
}
