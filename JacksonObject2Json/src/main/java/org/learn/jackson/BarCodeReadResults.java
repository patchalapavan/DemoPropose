package org.learn.jackson;


public class BarCodeReadResults {
	
	String barCode;
	String barCodeType;
	String errorCode;
	int slotNumber;

	public BarCodeReadResults() {}
	/*public BarCodeReadResults(String barCode, String barCodeType, String errorCode, int slotNumber) {
		this.barCode = barCode;
		this.barCodeType = barCodeType;
		this.errorCode = errorCode;
		this.slotNumber = slotNumber;
	}*/
	
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public String getBarCodeType() {
		return barCodeType;
	}
	public void setBarCodeType(String barCodeType) {
		this.barCodeType = barCodeType;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	
	

}
