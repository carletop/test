package com.webapp.api.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@XmlRootElement(name="PDBerror")
public class PDBerror {
	
	@XmlAttribute
    @JsonSerialize
	public String DBError;
}
