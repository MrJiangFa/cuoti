package annotation.p623;

import java.util.List;

public class PasswordUtils {
    @UseCase(id = 47, description = "password must contain at least one numeric")
    public boolean isValid(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "new password can not equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
