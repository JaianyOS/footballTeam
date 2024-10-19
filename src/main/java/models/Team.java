import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do time não pode ser vazio")
    private String name;

    @ElementCollection
    @Size(max = 5, message = "O time não pode ter mais de 5 jogadores")
    @NotEmpty(message = "A lista de jogadores não pode ser vazia")
    private List<@NotEmpty(message = "O nome do jogador não pode ser vazio") String> players;
}