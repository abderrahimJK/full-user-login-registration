package ma.bouna.fulluserloginregestration.repository;

import ma.bouna.fulluserloginregestration.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}
