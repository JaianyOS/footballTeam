package controllers;


import controllers.DTOs.TeamRegisterDTO;
import controllers.DTOs.TeamUpdateDTO;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TeamService;
import service.mapper.TeamMapper;

import java.util.Map;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/{teamId}")
    public ResponseEntity<?> getTeam(@PathVariable Long teamId) {
        try {
            return ResponseEntity.ok(TeamMapper.toTeamResponseDto(teamService.findTeamById(teamId)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeam(@RequestBody @Valid TeamRegisterDTO teamRegisterDTO) {
        teamService.createTeam(TeamMapper.toTeam(teamRegisterDTO));
    }
    @PutMapping("/{teamId}")
    public ResponseEntity<?> updateTeam(@RequestBody @Valid TeamUpdateDTO teamUpdateDTO, @PathVariable Long teamId) {
        try {
            teamService.updateTeam(teamId, teamUpdateDTO);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping ("/{teamId}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long teamId) {
        try {
            teamService.deleteTeam(teamId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        }
    }

}
