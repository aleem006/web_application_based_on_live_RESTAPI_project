package com.vac.model;

public class Certificate {
	private String vesselImo;
	private String vesselType;
	private String certificate;
	private String certificateType;

	public Certificate() {
		super();
	}

	public Certificate(String vesselImo, String vesselType, String certificate, String certificateType) {
		super();
		this.vesselImo = vesselImo;
		this.vesselType = vesselType;
		this.certificate = certificate;
		this.certificateType = certificateType;
	}

	public String getVesselImo() {
		return vesselImo;
	}

	public void setVesselImo(String vesselImo) {
		this.vesselImo = vesselImo;
	}

	public String getVesselType() {
		return vesselType;
	}

	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	@Override
	public String toString() {
		return "\nCertificate:\nvesselImo=" + vesselImo + "\nvesselType=" + vesselType + "\ncertificate=" + certificate
				+ "\ncertificateType=" + certificateType + "]\n";
	}

}
