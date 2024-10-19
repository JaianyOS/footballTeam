package service;

import controllers.DTOs.TeamUpdateDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.TeamRepository;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team findTeamById(Long teamId) {
        return teamRepository.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
    }

    public void createTeam(Team team) {
        teamRepository.save(team);
    }

    public void updateTeam(Long teamId, TeamUpdateDTO teamUpdateDTO) {
        Team team = findTeamById(teamId);
        team.setName(teamUpdateDTO.getName());
        team.setPlayers(teamUpdateDTO.getPlayers());
        teamRepository.save(team);
    }
    public void deleteTeam(Long teamId) {
        if (teamRepository.existsById(teamId)) {
            teamRepository.deleteById(teamId);
        } else {
            throw new RuntimeException("Team not found");
        }
    }

}
