package demotest;

public class TestBean {
	
	private String userID;
	public String getUserID() {
		return userID;} 
	public void setUserID(String userID) {
		this.userID = userID;}

	private String password;
	public String getPassword() {
		return password;}
	public void setPassword(String password) {
		this.password = password;}

	private String password2;
	public String getPassword2() {
		return password2;} 
	public void setPassword2(String password2) {
		this.password2 = password2;}
	
	private String firstname;
	public String getFirstname() {
		return firstname;} 
	public void setFirstname(String firstname) {
		this.firstname = firstname;}

	private String lastname;
	public String getLastname() {
		return lastname;}
	public void setLastname(String lastname) {
		this.lastname = lastname;}

	private String email;
	public String getEmail() {
		return email;} 
	public void setEmail(String email) {
		this.email = email;}
	
	private String ss1;
	public String getSS1() {
		return ss1;} 
	public void setSS1(String ss1) {
		this.ss1 = ss1;}

	private String ss2;
	public String getSS2() {
		return ss2;}
	public void setSS2(String ss2) {
		this.ss2 = ss2;}

	private String ss3;
	public String getSS3() {
		return ss3;} 
	public void setSS3(String ss3) {
		this.ss3 = ss3;}
	
	private String city;
	public String getCity() {
		return city;} 
	public void setCity(String city) {
		this.city = city;}

	private String address;
	public String getAddress() {
		return address;}
	public void setAddress(String address) {
		this.address = address;}

	private String state;
	public String getState() {
		return state;} 
	public void setState(String state) {
		this.state = state;}

		private String zipcode;
	public String getZipcode() {
		return zipcode;} 
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;}
	
	private String errorMsg = "\n";
	public String getErrorMsg() {
		return errorMsg;}
	public void setErrorMsg(String addError) {
		this.errorMsg += addError;
	}
	
	private String errorMsgB = "\n";
	public String getErrorMsgB() {
		return errorMsgB;}
	public void setErrorMsgB(String addError) {
		this.errorMsgB += addError;}
	public void clearErrorMsgB() {
		this.errorMsgB = "";
	}
	
	public TestBean() {
		// TODO Auto-generated constructor stub
	}

}
