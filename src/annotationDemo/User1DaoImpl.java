package annotationDemo;

/**
 * 使用注解
 */
public class User1DaoImpl {
    @UseCases(id = "47",desription = "this is my first annotationDemo.")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCases(id= "48")
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
