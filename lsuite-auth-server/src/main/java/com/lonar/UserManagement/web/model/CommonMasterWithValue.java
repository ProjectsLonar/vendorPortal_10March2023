package com.lonar.UserManagement.web.model;

import java.util.List;

import javax.validation.Valid;

public class CommonMasterWithValue {
	private @Valid LtMastComnMaster ltMastComnMaster;
	private @Valid List<LtMastComnMasterValues> ltMastComnMasterValues;
	//private @Valid String updateFlag;
	
	
	
	public LtMastComnMaster getLtMastComnMaster() {
		return ltMastComnMaster;
	}
	public void setLtMastComnMaster(LtMastComnMaster ltMastComnMaster) {
		this.ltMastComnMaster = ltMastComnMaster;
	}
	public List<LtMastComnMasterValues> getLtMastComnMasterValues() {
		return ltMastComnMasterValues;
	}
	public void setLtMastComnMasterValues(List<LtMastComnMasterValues> ltMastComnMasterValues) {
		this.ltMastComnMasterValues = ltMastComnMasterValues;
	}
	@Override
	public String toString() {
		return "CommonMasterWithValue [ltMastComnMaster=" + ltMastComnMaster + ", ltMastComnMasterValues="
				+ ltMastComnMasterValues + "]";
	}

	/*public String getUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}*/
	


}
