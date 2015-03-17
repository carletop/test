/**
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

import org.onebusaway.csv_entities.schema.annotations.CsvField;
import org.onebusaway.csv_entities.schema.annotations.CsvFields;
import org.onebusaway.gtfs.model.calendar.ServiceDate;
import org.onebusaway.gtfs.serialization.mappings.DefaultAgencyIdTranslator;
import org.onebusaway.gtfs.serialization.mappings.ServiceDateFieldMappingFactory;
import org.onebusaway.gtfs.serialization.mappings.AgencyListTranslator;
import org.onebusaway.gtfs.serialization.mappings.AgencyNamesTranslator;


@CsvFields(filename = "feed_info.txt", required = false, prefix = "feed_")
public final class FeedInfo extends IdentityBean<Integer> {

  private static final long serialVersionUID = 1L;

  @CsvField(ignore = true)
  private int id;

  @CsvField(name = "feed_lang", optional = true, mapping = DefaultAgencyIdTranslator.class)
  private String defaultId;
  
  @CsvField(name = "feed_lang", optional = true, mapping = AgencyListTranslator.class)
  private String agencyIds;
  
  @CsvField(name = "feed_lang", optional = true, mapping = AgencyNamesTranslator.class)
  private String agencyNames;
  
  @CsvField(optional = true)
  private String feedName;
  
  private String publisherName;

  private String publisherUrl;

  private String lang;

  @CsvField(optional = true, mapping = ServiceDateFieldMappingFactory.class)
  private ServiceDate startDate;

  @CsvField(optional = true, mapping = ServiceDateFieldMappingFactory.class)
  private ServiceDate endDate;

  @CsvField(optional = true)
  private String version;
  
  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public String getPublisherUrl() {
    return publisherUrl;
  }

  public void setPublisherUrl(String publisherUrl) {
    this.publisherUrl = publisherUrl;
  }

  public String getLang() {
    return lang;
  }

  public void setLang(String lang) {
    this.lang = lang;
  }

  public ServiceDate getStartDate() {
    return startDate;
  }

  public void setStartDate(ServiceDate startDate) {
    this.startDate = startDate;
  }

  public ServiceDate getEndDate() {
    return endDate;
  }

  public void setEndDate(ServiceDate endDate) {
    this.endDate = endDate;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  /****
   * {@link IdentityBean} Interface
   ****/

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getDefaultId() {
    return defaultId;
  }

  public void setDefaultId(String defaultId) {
    this.defaultId = defaultId;
  }
  
  public String getAgencyIds() {
    return agencyIds;
  }

  public void setAgencyIds(String agencyIds) {
    this.agencyIds = agencyIds;
  }
  
  public String getAgencyNames() {
    return agencyNames;
  }

  public void setAgencyNames(String agencyNames) {
    this.agencyNames = agencyNames;
  }
  
  public String getFeedName() {
    return feedName;
  }

  public void setFeedName(String feedName) {
    this.feedName = feedName;
  }
  
}
