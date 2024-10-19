package controllers.DTOs;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class TeamUpdateDTO {

    @Size(min = 4, message = "team name must have at lest 4 characters")
    private String name;

    @NotEmpty(message = "players list cannot be empty")
    @Size(max = 5, message = "a team cannot have more than 5 players")
    private List<String> players;

    public TeamUpdateDTO() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }
}
