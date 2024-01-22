package ma.bouna.fulluserloginregestration.record;

public record UserRegistration(
        Long id,
        String firstName,
        String lastName,
        String email,
        String password,
        String role
) {
}
