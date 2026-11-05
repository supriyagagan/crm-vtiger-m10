package types_of_exe;

import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void validLogin() {
        System.out.println("Valid Login Test");
    }

    @Test
    public void invalidLogin() {
        System.out.println("Invalid Login Test");
    }

    @Test
    public void logoutTest() {
        System.out.println("Logout Test");
    }
}