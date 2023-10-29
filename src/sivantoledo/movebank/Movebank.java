/*

Specify one of the following entity types: deployment, event, individual, sensor, study, study_attribute, tag, tag_type, taxon
Optional parameter: header-format=underscore
When connecting via https you must specify the parameters user=... and password=...
Specify output attributes and filter conditions depending on the entity type.

entity-type=study
Output attributes: access_profile_download_id, access_profile_id, acknowledgements, bounding_box, citation, comments, contact_person_id, default_profile_eventdata_id, default_profile_refdata_id, external_id, external_id_namespace_id, grants_used, has_quota, i_am_owner, i_can_see_data, id, license_terms, location_description, main_location_lat, main_location_long, name, number_of_deployments, number_of_events, number_of_individuals, number_of_tags, principal_investigator_address, principal_investigator_email, principal_investigator_id, principal_investigator_name, study_id, study_objective, study_type, suspend_license_terms, there_are_data_which_i_cannot_see, timestamp_end, timestamp_start
Filter attributes: access_profile_download_id, access_profile_id, acknowledgements, bounding_box, citation, comments, contact_person_id, default_profile_eventdata_id, default_profile_refdata_id, external_id, external_id_namespace_id, grants_used, has_quota, i_am_owner, id, license_terms, location_description, main_location_lat, main_location_long, name, number_of_deployments, number_of_events, number_of_individuals, number_of_tags, principal_investigator_address, principal_investigator_email, principal_investigator_id, principal_investigator_name, study_id, study_objective, study_type, suspend_license_terms, timestamp_end, timestamp_start

entity-type=individual
Output attributes: access_profile_id, comments, death_comments, default_profile_eventdata_id, earliest_date_born, exact_date_of_birth, external_id, external_id_namespace_id, i_am_owner, id, latest_date_born, local_identifier, ring_id, sex, study_id, taxon_canonical_name, taxon_id
Filter attributes: access_profile_id, comments, death_comments, default_profile_eventdata_id, earliest_date_born, exact_date_of_birth, external_id, external_id_namespace_id, i_am_owner, id, latest_date_born, local_identifier, ring_id, sex, study_id, taxon_canonical_name, taxon_id

entity-type=tag
Output attributes: access_profile_id, beacon_frequency, comments, external_id, external_id_namespace_id, i_am_owner, id, local_identifier, manufacturer_name, model, processing_type, serial_no, study_id, tag_failure_comments, tag_production_date, tag_type_id, weight
Filter attributes: access_profile_id, beacon_frequency, comments, external_id, external_id_namespace_id, i_am_owner, id, local_identifier, manufacturer_name, model, processing_type, serial_no, study_id, tag_failure_comments, tag_production_date, tag_type_id, weight

entity-type=sensor
Output attributes: external_id, external_id_namespace_id, id, manufacturer_name, model, sensor_type_id, tag_id, tag_study_id
Filter attributes: external_id, external_id_namespace_id, id, manufacturer_name, model, sensor_type_id, tag_id, tag_study_id

entity-type=tag_type
Output attributes: description, external_id, external_id_namespace_id, id, is_location_sensor, name
Filter attributes: description, external_id, external_id_namespace_id, id, is_location_sensor, name

entity-type=taxon
Output attributes: author_string, canonical_name, external_id, external_id_namespace_id, hierarchy_string, id, name_1, name_2, name_3, parent_taxon_id
Filter attributes: author_string, canonical_name, external_id, external_id_namespace_id, hierarchy_string, id, name_1, name_2, name_3, parent_taxon_id

entity-type=deployment
Output attributes: access_profile_id, animal_life_stage, animal_mass, animal_reproductive_condition, attachment_type, behavior_according_to, comments, data_processing_software, deploy_off_latitude, deploy_off_longitude, deploy_off_person, deploy_off_timestamp, deploy_on_latitude, deploy_on_longitude, deploy_on_person, deploy_on_timestamp, deployment_end_comments, deployment_end_type, duty_cycle, external_id, external_id_namespace_id, geolocator_calibration, geolocator_light_threshold, geolocator_sensor_comments, geolocator_sun_elevation_angle, habitat_according_to, i_am_owner, id, individual_id, local_identifier, location_accuracy_comments, manipulation_comments, manipulation_type, partial_identifier, study_id, study_site, tag_id, tag_readout_method
Filter attributes: access_profile_id, animal_life_stage, animal_mass, animal_reproductive_condition, attachment_type, behavior_according_to, comments, data_processing_software, deploy_off_latitude, deploy_off_longitude, deploy_off_person, deploy_off_timestamp, deploy_on_latitude, deploy_on_longitude, deploy_on_person, deploy_on_timestamp, deployment_end_comments, deployment_end_type, duty_cycle, external_id, external_id_namespace_id, geolocator_calibration, geolocator_light_threshold, geolocator_sensor_comments, geolocator_sun_elevation_angle, habitat_according_to, i_am_owner, id, individual_id, local_identifier, location_accuracy_comments, manipulation_comments, manipulation_type, partial_identifier, study_id, study_site, tag_id, tag_readout_method

entity-type=event
Output attributes: acceleration_axes, acceleration_raw_x, acceleration_raw_y, acceleration_raw_z, acceleration_sampling_frequency_per_axis, acceleration_x, acceleration_y, acceleration_z, accelerations_raw, activity_count, activity_count, algorithm_marked_outlier, argos_altitude, argos_best_level, argos_calcul_freq, argos_error_radius, argos_gdop, argos_iq, argos_lat1, argos_lat2, argos_lc, argos_lon1, argos_lon2, argos_nb_mes, argos_nb_mes_120, argos_nb_mes_identical, argos_nopc, argos_orientation, argos_pass_duration, argos_sat_id, argos_semi_major, argos_semi_minor, argos_sensor_1, argos_sensor_2, argos_sensor_3, argos_sensor_4, argos_transmission_timestamp, argos_valid_location_algorithm, argos_valid_location_manual, barometric_depth, barometric_pressure, bas_compensated_latitute, bas_confidence, bas_fix_type, bas_mid_value_secs, bas_stationary_latitute, bas_transition_1, bas_transition_2, behavioural_classification, comments, compass_heading, deployment_id, eobs_acceleration_axes, eobs_acceleration_sampling_frequency_per_axis, eobs_accelerations_raw, eobs_activity, eobs_activity_samples, eobs_battery_voltage, eobs_fix_battery_voltage, eobs_horizontal_accuracy_estimate, eobs_key_bin_checksum, eobs_speed_accuracy_estimate, eobs_start_timestamp, eobs_status, eobs_temperature, eobs_type_of_fix, eobs_used_time_to_get_fix, event_id, event_set_id, external_temperature, flt_switch, gps_fix_type, gps_hdop, gps_maximum_signal_strength, gps_satellite_count, gps_time_to_fix, gps_vdop, ground_speed, gsm_mcc_mnc, gsm_signal_strength, gt_activity_count, gt_sys_week, gt_tx_count, habitat, heading, height_above_ellipsoid, height_above_msl, height_raw, individual_id, internal_temperature, light_level, location_error_numerical, location_error_percentile, location_error_text, location_lat, location_long, magnetic_field_raw_x, magnetic_field_raw_y, magnetic_field_raw_z, manually_marked_outlier, migration_stage, migration_stage_standard, modelled, mw_activity_count, mw_show_in_kml, proofed, raptor_workshop_behaviour, raptor_workshop_deployment_special_event, raptor_workshop_migration_state, sensor_type_id, study_id, study_specific_measurement, tag_battery_voltage, tag_id, tag_tech_spec, tag_voltage, technosmart_activity, technosmart_signal_quality, tilt_angle, tilt_x, tilt_y, tilt_z, timestamp, transmission_timestamp, underwater_count, underwater_time, vertical_error_numerical, visible, waterbird_workshop_behaviour, waterbird_workshop_deployment_special_event, waterbird_workshop_migration_state
Filter attributes: acceleration_axes, acceleration_raw_x, acceleration_raw_y, acceleration_raw_z, acceleration_sampling_frequency_per_axis, acceleration_x, acceleration_y, acceleration_z, accelerations_raw, activity_count, activity_count, algorithm_marked_outlier, argos_altitude, argos_best_level, argos_calcul_freq, argos_error_radius, argos_gdop, argos_iq, argos_lat1, argos_lat2, argos_lc, argos_lon1, argos_lon2, argos_nb_mes, argos_nb_mes_120, argos_nb_mes_identical, argos_nopc, argos_orientation, argos_pass_duration, argos_sat_id, argos_semi_major, argos_semi_minor, argos_sensor_1, argos_sensor_2, argos_sensor_3, argos_sensor_4, argos_transmission_timestamp, argos_valid_location_algorithm, argos_valid_location_manual, barometric_depth, barometric_pressure, bas_compensated_latitute, bas_confidence, bas_fix_type, bas_mid_value_secs, bas_stationary_latitute, bas_transition_1, bas_transition_2, behavioural_classification, comments, compass_heading, deployment_id, eobs_acceleration_axes, eobs_acceleration_sampling_frequency_per_axis, eobs_accelerations_raw, eobs_activity, eobs_activity_samples, eobs_battery_voltage, eobs_fix_battery_voltage, eobs_horizontal_accuracy_estimate, eobs_key_bin_checksum, eobs_speed_accuracy_estimate, eobs_start_timestamp, eobs_status, eobs_temperature, eobs_type_of_fix, eobs_used_time_to_get_fix, event_id, event_set_id, external_temperature, flt_switch, gps_fix_type, gps_hdop, gps_maximum_signal_strength, gps_satellite_count, gps_time_to_fix, gps_vdop, ground_speed, gsm_mcc_mnc, gsm_signal_strength, gt_activity_count, gt_sys_week, gt_tx_count, habitat, heading, height_above_ellipsoid, height_above_msl, height_raw, individual_id, internal_temperature, light_level, location_error_numerical, location_error_percentile, location_error_text, location_lat, location_long, magnetic_field_raw_x, magnetic_field_raw_y, magnetic_field_raw_z, manually_marked_outlier, migration_stage, migration_stage_standard, modelled, mw_activity_count, mw_show_in_kml, proofed, raptor_workshop_behaviour, raptor_workshop_deployment_special_event, raptor_workshop_migration_state, sensor_type_id, study_id, study_specific_measurement, tag_battery_voltage, tag_id, tag_tech_spec, tag_voltage, technosmart_activity, technosmart_signal_quality, tilt_angle, tilt_x, tilt_y, tilt_z, timestamp, transmission_timestamp, underwater_count, underwater_time, vertical_error_numerical, visible, waterbird_workshop_behaviour, waterbird_workshop_deployment_special_event, waterbird_workshop_migration_state

entity-type=study_attribute
Output attributes: data_type, sensor_type_id, short_name, study_id
Filter attributes: data_type, sensor_type_id, short_name, study_id

Example query string: ?entity-type=individual&study=80355,80725&attributes=id,local-identifier,taxon

 */

package sivantoledo.movebank;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;





import sivantoledo.util.Base64;

import com.opencsv.CSVReader;

//import tau.atlas.movebank.Base64;

public class Movebank {
  
  //private final static Logger log = LogManager.getLogger();
  
  //private String filename;
  //private String localDirectory;
  private static String baseUrl = "https://www.movebank.org/movebank/service/direct-read?";
  
  private String explanation = null;
  public  String explanation() { return explanation; }
  
  private static String userPassword; 
  public static void    setUserPassword(String userPassword) { Movebank.userPassword = userPassword; }
  public static boolean hasUserPassword()                    { return userPassword != null;          }
  
  public interface Parser { public void parse(Map<String,String> row); }

  public static int get(String table, String filter, String attributes, Parser parser) {
    //explanation = null;
    
    InputStream http_is = null;
    
    String urlstring;
    urlstring = baseUrl + "entity_type=" + table;
    if (filter!=null) urlstring += "&" + filter;
    if (attributes!=null) urlstring += "&attributes=" + attributes;
    
    //System.out.printf("%s\n",urlstring);
    
    try {
      java.net.URL url = new java.net.URL(urlstring);      
      java.net.URLConnection conn = url.openConnection();
     
      if (userPassword != null) {
        String base64String = Base64.encodeBytes(userPassword.getBytes("UTF-8"));
        conn.setRequestProperty("Authorization", "Basic " + base64String);
      }
      
      http_is = conn.getInputStream();
    } catch (IOException e) {
      if (e.getMessage().contains("HTTP") && e.getMessage().contains("401"))
        throw new MovebankReader.LicenseException("was not able to get table "+table);
      System.err.println("could not get movebank data " + ": " + e.getMessage());
    }

    if (http_is==null) {
      System.err.printf("could not retrieve movebank table %s\n",table);
      //throw new MovebankReader.LicenseException("was not able to get table "+table);
      return -1;
    }
    
    MovebankReader mbr;
    try {
      mbr = new MovebankReader( new InputStreamReader(http_is, "UTF-8") );
    } catch (UnsupportedEncodingException e1) {
      e1.printStackTrace();
      return -1;
    }
    
    CSVReader csv = new CSVReader( mbr );
    Map<Integer,String> fields = new HashMap<Integer,String>();
    String [] line;
    int i = 0;
    try {
      while ((line = csv.readNext()) != null) {
        if (i==0) {
          for (int j=0; j<line.length; j++) fields.put(j, line[j]);
        } else {
          Map<String,String> row = new HashMap<String,String>();
          for (int j=0; j<line.length; j++) {
            if (line[j] != null && line[j].length()>0) {
              row.put(fields.get(j), line[j]);
            }
          }
          //System.out.printf("row %d = %s\n",i,row);
          parser.parse(row);
        }
        i++;
      }
    } catch (IOException ioe) {
      try { http_is.close(); } catch (IOException e) {}
      //explanation += "; failed: cannot create or write to local file";
      return -1;
    } finally {
      try { csv.close();     } catch(IOException ioe) {}
      try { http_is.close(); } catch(IOException ioe) {}
    }
    
    
    /*
    OutputStream file_os = System.out;
    
    try {
      file_os = new FileOutputStream("xxx.csv");
    } catch (IOException ioe) {
      try { http_is.close(); } catch (IOException e) {}
      //explanation += "; failed: cannot create or write to local file";
      return -1;
    }
    
    // Transfer bytes from in to out
    byte[] buf = new byte[64 * 1024];
    int len;
    try {
      while ((len = http_is.read(buf)) > 0) {
        file_os.write(buf, 0, len);
      }
    } catch (IOException ioe) {
      try { http_is.close(); } catch (IOException e) {}
      try { file_os.close(); } catch (IOException e) {}
      //f.delete();
      //explanation += "; failed";
      return -1;
    }
    */


    try { http_is.close(); } catch (IOException e) {}
    //try { file_os.close(); } catch (IOException e) {}
    
    //explanation += "; succeeded";
    
    return 1;
  }
  
  public static void main(String[] args) { // 91931153 cranes
    Parser parser = new Parser() { public void parse(Map<String,String> row) {System.out.printf("%s\n",row);} };
    //Movebank.get("study","i_can_see_data=true","id,name,i_can_see_data", parser);
    //Movebank.get("tag","study_id=91931153","id,local_identifier", parser);
    //Movebank.get("deployment","study_id=91931153",null, parser);
    //Movebank.get("tag_type",null,null, parser);
    Movebank.get("event","study_id=91931153&sensor_type_id=653&individual_id=135539252","location_long,location_lat,timestamp,individual_id,tag_id", parser);
    //Movebank.get("direct-read?entity_type=deployment&study_id=91931153&attributes=access_profile_id,animal_life_stage,animal_mass,animal_reproductive_condition,attachment_type,behavior_according_to,comments,data_processing_software,deploy_off_latitude,deploy_off_longitude,deploy_off_person,deploy_off_timestamp,deploy_on_latitude,deploy_on_longitude,deploy_on_person,deploy_on_timestamp,deployment_end_comments,deployment_end_type,duty_cycle,external_id,external_id_namespace_id,geolocator_calibration,geolocator_light_threshold,geolocator_sensor_comments,geolocator_sun_elevation_angle,habitat_according_to,i_am_owner,id,individual_id,local_identifier,location_accuracy_comments,manipulation_comments,manipulation_type,partial_identifier,study_id,study_site,tag_id,tag_readout_method","https://www.movebank.org/movebank/service/","sivantoledo:q1w2e3r4t5");
    //Movebank.get("direct-read?entity_type=individual&study_id=91931153&attributes=id,taxon_id,comments,local_identifier", "https://www.movebank.org/movebank/service/", "sivantoledo:q1w2e3r4t5");
    //Movebank.get("direct-read?entity_type=taxon&id=12577&attributes=canonical_name", "https://www.movebank.org/movebank/service/", "sivantoledo:q1w2e3r4t5");
    //Movebank.get("direct-read?entity_type=tag&study_id=91931153", "https://www.movebank.org/movebank/service/", "sivantoledo:q1w2e3r4t5");
    //Movebank.get("direct-read?entity_type=tag&study_id=91931153&attributes=access_profile_id,beacon_frequency,comments,external_id,external_id_namespace_id,i_am_owner,id,local_identifier,manufacturer_name,model,processing_type,serial_no,study_id,tag_failure_comments,tag_production_date,tag_type_id,weight", "https://www.movebank.org/movebank/service/", "sivantoledo:q1w2e3r4t5");
    //Movebank.get("direct-read?entity_type=tag_type&study_id=91931153", "https://www.movebank.org/movebank/service/", "sivantoledo:q1w2e3r4t5");
    //Movebank.get("direct-read?entity_type=event&study_id=91931153", "https://www.movebank.org/movebank/service/", "sivantoledo:q1w2e3r4t5");
    //Movebank.get("direct-read?entity_type=study_attribute&study_id=91931153", "https://www.movebank.org/movebank/service/", "sivantoledo:q1w2e3r4t5");
    //Movebank.get("direct-read?entity_type=individual&study_id=91931153", "https://www.movebank.org/movebank/service/", "sivantoledo:q1w2e3r4t5");
    //Movebank.get("direct-read?attributes", "https://www.movebank.org/movebank/service/", "sivantoledo:q1w2e3r4t5");
  }
}
