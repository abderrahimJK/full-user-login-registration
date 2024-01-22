package ma.bouna.fulluserloginregestration.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String refreshToken;
    private Instant expirationTime;
    @OneToOne
    private User user;

}

