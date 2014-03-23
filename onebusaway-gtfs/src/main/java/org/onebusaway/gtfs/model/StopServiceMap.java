/**
 * Copyright (C) 2011 Brian Ferris <bdferris@onebusaway.org>
 * Copyright (C) 2011 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onebusaway.gtfs.model;

import org.onebusaway.gtfs.model.Stop;

//@CsvFields(filename = "agency.txt", prefix = "agency_")
public final class StopServiceMap extends IdentityBean<String> {

  private static final long serialVersionUID = 1L;

  //@CsvField(optional = true, mapping = AgencyIdTranslationFieldMappingFactory.class)
  private String id;

  private String agencyId;
  
  private String agencyId_def;

  private String stopId;
  
  private Stop stop;
  
  
  public void setStop(Stop stop) {
      this.agencyId_def = stop.getId().getAgencyId();
      this.stopId = stop.getId().getId();
  }

  public StopServiceMap() {

  }

  public StopServiceMap(StopServiceMap a) {
    this.id = a.id;
    this.agencyId = a.agencyId;
    this.stopId = a.stopId;    
  }

  public String getId() {
    return id;
  }
  
  public Stop getStop(){
	  return stop;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getagencyId() {
    return agencyId;
  }
  public String getagencyId_def() {
	    return agencyId_def;
	  }
  public void setagencyId(String agencyId) {
    this.agencyId = agencyId;
  }
  public void setagencyId_def(String agencyId_def) {
	    this.agencyId_def = agencyId_def;
	  }

  public String getstopId() {
    return stopId;
  }

  public void setstopId(String stopId) {
    this.stopId = stopId;
  }
  
  public String toString() {
    return "<Agency " + this.id + "Serves Stop"+ this.stopId+ ">";
  }
}
