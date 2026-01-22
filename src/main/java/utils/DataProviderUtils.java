package utils;
import org.testng.annotations.DataProvider;

public class DataProviderUtils {
	@DataProvider(name="productSmoke")
	public Object[][] productSmoke() {
	    return new Object[][]{
	        {"Mobile"}   // or "shoes" (choose 1 stable item)
	    };
	}

	@DataProvider(name="cridential")
	public Object[][] getLoginCridential() {

	    Object[][] loginData = new Object[4][2];

	    // test 1 - valid data
	    loginData[0][0] = "sharmashalina01@gmail.com";
	    loginData[0][1] = "sharmashalina01";

	    // test 2 - valid email, invalid password
	    loginData[1][0] = "sharmashalina01@gmail.com";
	    loginData[1][1] = "abcd123";

	    // test 3 - invalid email, invalid password
	    loginData[2][0] = "abcd123@gmail.com";
	    loginData[2][1] = "ahllgi";

	    // test 4 - empty
	    loginData[3][0] = "";
	    loginData[3][1] = "";

	    return loginData;
	}

	 @DataProvider(name = "registrationData")
	    public Object[][] getRegistrationData(){

	        Object[][] data = new Object[5][4];

	        data[0][0] = "Shalina";
	        data[0][1] = "abc23@gmail.com";
	        data[0][2] = "Test@123";
	        data[0][3] = "Test@123";

	        data[1][0] = "Shalina";
	        data[1][1] = "abc23@gmail.com";
	        data[1][2] = "Test@123";
	        data[1][3] = "Test@123";

	        data[2][0] = "Shalina";
	        data[2][1] = "1111@gmail.com";
	        data[2][2] = "1111";
	        data[2][3] = "11111";

	        data[3][0] = "Shalina";
	        data[3][1] = "abc23@gmail.com";
	        data[3][2] = "123456";
	        data[3][3] = "123456";

	        data[4][0] = "";
	        data[4][1] = "";
	        data[4][2] = "";
	        data[4][3] = "";

	        return data;
	    }
	
	

}
