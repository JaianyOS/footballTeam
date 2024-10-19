package controllers.DTOs;

import java.util.List;

public class TeamResponseDTO {
    private Long id;
    private String name;
    private List<String> players;

    public TeamResponseDTO() {}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
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
