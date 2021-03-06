﻿drop table if exists census_tracts_trip_map;

CREATE TABLE census_tracts_trip_map
(
  gid serial NOT NULL,
  agencyid character varying(255),
  agencyid_def character varying(255),
  routeid character varying(255),
  tractid character varying(11),
  tripid character varying(255),
  serviceid character varying(255),
  stopscount integer,  
  length float,
  tlength int,
  shape geometry(multilinestring),
  uid varchar(512),
  CONSTRAINT census_tracts_trip_map_pkey PRIMARY KEY (gid),
  CONSTRAINT census_tracts_trip_map_fkey FOREIGN KEY (agencyid, tripid)
      REFERENCES gtfs_trips (agencyid, id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE census_tracts_trip_map
  OWNER TO postgres;

insert into census_tracts_trip_map(tripid, agencyid, agencyid_def, serviceid, routeid,  tractid, shape, length, uid) 
select trip.id, trip.agencyid, trip.serviceid_agencyid, trip.serviceid_id, trip.route_id, tract.tractid, st_multi(ST_CollectionExtract(st_union(ST_Intersection(trip.shape,tract.shape)),2)), (ST_Length(st_transform(ST_Intersection(trip.shape,tract.shape),2993))/1609.34), trip.uid
from gtfs_trips trip
inner join census_tracts tract on  st_intersects(tract.shape,trip.shape)=true group by trip.id, trip.agencyid, tract.tractid;

update census_tracts_trip_map set stopscount = res.cnt+0 from 
(select count(stop.id) as cnt, substring(stop.blockid,1,11) as cid, stime.trip_agencyid as aid, stime.trip_id as tid 
from gtfs_stops stop inner join gtfs_stop_times stime 
on stime.stop_agencyid = stop.agencyid and stime.stop_id = stop.id group by stime.trip_agencyid, stime.trip_id, substring(stop.blockid,1,11)) as res
where tractid =  res.cid and agencyid = res.aid and tripid=res.tid;

update census_tracts_trip_map set stopscount=0 where stopscount IS NULL;

update census_tracts_trip_map map set tlength=res.ttime from (
select max(stimes.departuretime)-min(stimes.arrivaltime) as ttime, 
stimes.agencyid, stimes.tripid, stimes.geoid from (
select stime.arrivaltime, stime.departuretime, stime.trip_agencyid as agencyid, stime.trip_id as tripid, substring(stop.blockid,1,11) as geoid
from gtfs_stop_times stime inner join gtfs_stops stop on stime.stop_agencyid = stop.agencyid and stime.stop_id = stop.id) as stimes
where stimes.arrivaltime>0 and stimes.departuretime>0 group by stimes.agencyid, stimes.tripid, stimes.geoid) as res 
where res.agencyid = map.agencyid and res.tripid=map.tripid and res.geoid=map.tractid;

update census_tracts_trip_map set tlength=0 where tlength isnull;