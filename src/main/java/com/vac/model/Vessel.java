package com.vac.model;

import java.util.ArrayList;

public class Vessel {
	private String vesselName;
	private String note;
	private String member;
	private String imo;
	private String builtYear;
	private String grossTonnage;
	private String vesselType;
	private String flagDescription;
	private String businessUnit;
	private String currentRegOwner;
	public ArrayList<Certificate> certificateList;

	public Vessel() {
		super();
		certificateList = new ArrayList<Certificate>();
	}

	public Vessel(String vesselName, String note, String member, String imo, String builtYear, String grossTonnage,
			String vesselType, String flagDescription, String businessUnit, String currentRegOwner) {
		super();
		this.vesselName = vesselName;
		this.note = note;
		this.member = member;
		this.imo = imo;
		this.builtYear = builtYear;
		this.grossTonnage = grossTonnage;
		this.vesselType = vesselType;
		this.flagDescription = flagDescription;
		this.businessUnit = businessUnit;
		this.currentRegOwner = currentRegOwner;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getImo() {
		return imo;
	}

	public void setImo(String imo) {
		this.imo = imo;
	}

	public String getBuiltYear() {
		return builtYear;
	}

	public void setBuiltYear(String builtYear) {
		this.builtYear = builtYear;
	}

	public String getGrossTonnage() {
		return grossTonnage;
	}

	public void setGrossTonnage(String grossTonnage) {
		this.grossTonnage = grossTonnage;
	}

	public String getVesselType() {
		return vesselType;
	}

	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
	}

	public String getFlagDescription() {
		return flagDescription;
	}

	public void setFlagDescription(String flagDescription) {
		this.flagDescription = flagDescription;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getCurrentRegOwner() {
		return currentRegOwner;
	}

	public void setCurrentRegOwner(String currentRegOwner) {
		this.currentRegOwner = currentRegOwner;
	}

	@Override
	public String toString() {
		String output = "Vessel:\n\nvesselName=" + vesselName + "\nnote=" + note + "\nmember=" + member + "\nimo=" + imo
				+ "\nbuiltYear=" + builtYear + "\ngrossTonnage=" + grossTonnage + "\nvesselType=" + vesselType
				+ "\nflagDescription=" + flagDescription + "\nbusinessUnit=" + businessUnit + "\ncurrentRegOwner="
				+ currentRegOwner + "\nCertificate List:\n";

		for (Certificate c : certificateList)
			output += c.toString();
		output += "------------------------\n\n";
		return output;
	}

}
