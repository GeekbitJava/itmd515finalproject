package authentication;

public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("geekbit") && password.equals("test");
	}

}