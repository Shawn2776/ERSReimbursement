package com.example.model;

import java.sql.Timestamp;

public class Reimbursement
{
	private int reimbursementId;
	private double reimbAmount;
	private Timestamp reimbSubmittedTS;
	private Timestamp reimbResolvedTS;
	private String reimbDescription;
	private int reimbAuthor;
	private int reimbResolver;
	private int reimbStatus;
	private int reimbType;
	
	private String reimbStatusName;
	private String reimbTypeName;
	private String authorFName;
	private String authorLName;
	private String authorEmail;
	
	
	
	public Reimbursement() {
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimbursementId, double reimbAmount, Timestamp reimbSubmittedTS,
			Timestamp reimbResolvedTS, String reimbDescription, int reimbAuthor, int reimbResolver, int reimbStatus,
			int reimbType) {
		super();
		this.reimbursementId = reimbursementId;
		this.reimbAmount = reimbAmount;
		this.reimbSubmittedTS = reimbSubmittedTS;
		this.reimbResolvedTS = reimbResolvedTS;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbResolver = reimbResolver;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
	}
	
	public Reimbursement(double reimbAmount, String reimbDescription, int reimbAuthor, int reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbAuthor = reimbAuthor;
		this.reimbType = reimbType;
	}
	
	public Reimbursement(int reimbursementId, int reimbAuthor, String authorFName, String authorLName, String authorEmail, String reimbTypeName,
			double reimbAmount, String reimbDescription, String reimbStatusName, Timestamp reimbSubmittedTS, Timestamp reimbResolvedTS, int reimbResolver)
	{
		super();
		this.reimbursementId = reimbursementId;
		this.reimbAuthor = reimbAuthor;
		this.authorFName = authorFName;
		this.authorLName = authorLName;
		this.authorEmail = authorEmail;
		this.reimbTypeName = reimbTypeName;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbStatusName = reimbStatusName;
		this.reimbSubmittedTS = reimbSubmittedTS;
		this.reimbResolvedTS = reimbResolvedTS;
		this.reimbResolver = reimbResolver;
	}

	public Reimbursement(int reimbursementId, int reimbStatus, int reimbType, String reimbDescription, double reimbAmount, Timestamp reimbSubmittedTS, Timestamp reimbResolvedTS, int reimbAuthor)
	{
		this.reimbursementId = reimbursementId;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
		this.reimbDescription = reimbDescription;
		this.reimbAmount = reimbAmount;
		this.reimbSubmittedTS = reimbSubmittedTS;
		this.reimbResolvedTS = reimbResolvedTS;
		this.reimbAuthor = reimbAuthor;
		
		
	}

	public double getReimbAmount() {
		return reimbAmount;
	}

	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}

	public Timestamp getReimbSubmittedTS() {
		return reimbSubmittedTS;
	}

	public void setReimbSubmittedTS(Timestamp reimbSubmittedTS) {
		this.reimbSubmittedTS = reimbSubmittedTS;
	}

	public Timestamp getReimbResolvedTS() {
		return reimbResolvedTS;
	}

	public void setReimbResolvedTS(Timestamp reimbResolvedTS) {
		this.reimbResolvedTS = reimbResolvedTS;
	}

	public String getReimbDescription() {
		return reimbDescription;
	}

	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}

	public int getReimbAuthor() {
		return reimbAuthor;
	}

	public void setReimbAuthor(int reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}

	public int getReimbResolver() {
		return reimbResolver;
	}

	public void setReimbResolver(int reimbResolver) {
		this.reimbResolver = reimbResolver;
	}

	public int getReimbStatus() {
		return reimbStatus;
	}

	public void setReimbStatus(int reimbStatus) {
		this.reimbStatus = reimbStatus;
	}

	public int getReimbType() {
		return reimbType;
	}

	public void setReimbType(int reimbType) {
		this.reimbType = reimbType;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}
	
	

	public String getReimbStatusName() {
		return reimbStatusName;
	}

	public void setReimbStatusName(String reimbStatusName) {
		this.reimbStatusName = reimbStatusName;
	}

	public String getReimbTypeName() {
		return reimbTypeName;
	}

	public void setReimbTypeName(String reimbTypeName) {
		this.reimbTypeName = reimbTypeName;
	}

	public String getAuthorFName() {
		return authorFName;
	}

	public void setAuthorFName(String authorFName) {
		this.authorFName = authorFName;
	}

	public String getAuthorLName() {
		return authorLName;
	}

	public void setAuthorLName(String authorLName) {
		this.authorLName = authorLName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	@Override
	public String toString() {
		return "ReimbursementModel [reimbursementId=" + reimbursementId + ", reimbAmount=" + reimbAmount
				+ ", reimbSubmittedTS=" + reimbSubmittedTS + ", reimbResolvedTS=" + reimbResolvedTS
				+ ", reimbDescription=" + reimbDescription + ", reimbAuthor=" + reimbAuthor + ", reimbResolver="
				+ reimbResolver + ", reimbStatus=" + reimbStatus + ", reimbType=" + reimbType + "]";
	}
	
	
	
	
}
