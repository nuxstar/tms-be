package com.flyers.tms.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class contains all the helper functions for
 * ams project.
 */
public interface TmsUtility {
  /**
   * Convert Object to json.
   */
  static String convertObjectToJson(Object object) throws JsonProcessingException {
    if (object == null) {
      return null;
    }
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(object);
  }

}
