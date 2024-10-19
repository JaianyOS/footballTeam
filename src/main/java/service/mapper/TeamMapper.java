package service.mapper;

import controllers.DTOs.TeamRegisterDTO;
import controllers.DTOs.TeamResponseDTO;
import models.Team;

public class TeamMapper {
    public static Team toTeam(TeamRegisterDTO teamRegisterDTO) {
        Team team = new Team();
        team.setName(teamRegisterDTO.getName());
        team.setPlayers(teamRegisterDTO.getPlayers());
        return team;
    }

    public static TeamResponseDTO toTeamResponseDto(Team team) {
        TeamResponseDTO teamResponseDTO = new TeamResponseDTO();
        teamResponseDTO.setId(team.getId());
        teamResponseDTO.setName(team.getName());
        teamResponseDTO.setPlayers(team.getPlayers());
        return teamResponseDTO;
    }
}
