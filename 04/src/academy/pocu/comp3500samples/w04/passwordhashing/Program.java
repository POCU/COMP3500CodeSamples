package academy.pocu.comp3500samples.w04.passwordhashing;

public class Program {
    public static void main(String[] args) {
        User user = new User("myemail@email.com",
                "My StRoNg P@$$word");

        System.out.println(
                String.format("ID: %s",
                        user.getId()));

        System.out.println(
                String.format("Email: %s",
                        user.getEmail()));

        System.out.println(
                String.format("Password Hash: %s",
                        user.getPaswordHash()));

        boolean isValid = user.isValidPassword("wrong password!");

        System.out.println(isValid);

        isValid = user.isValidPassword("My StRoNg P@$$word");

        System.out.println(isValid);
    }
}
