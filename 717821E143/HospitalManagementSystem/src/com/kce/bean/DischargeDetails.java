package com.kce.bean;

public class DischargeDetails extends Hospital {
	public int admissionNo;
	public String dateOfDischarge;
	//CONSTRUCTOR
	public DischargeDetails() {
		super();
	}

	public DischargeDetails(int admissionNo, String name, String bloodGroup, String disease, String dateOfJoin,String dateOfDischarge) {
		super(admissionNo, name, bloodGroup, disease, dateOfJoin);
		this.dateOfDischarge=dateOfDischarge;
	}
	//GETTER AND SETTER
	
	public int getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(int admissionNo) {
		this.admissionNo = admissionNo;
	}
	public String getDateOfDischarge() {
		return dateOfDischarge;
	}
	public void setDateOfDischarge(String dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}
//TOSTRING METHOD
	@Override
	public String toString() {
		return "DischargeDetails [admission_no=" + admissionNo + ", date_of_discharge=" + dateOfDischarge
				+  "]";
	}

}
