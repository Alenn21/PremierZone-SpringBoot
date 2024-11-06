package com.premier.premierZone.player;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController (PlayerService playerService){
        this.playerService=playerService;
    }

    @GetMapping
    public List<Player> getPlayers (
        @RequestParam(required = false) String team,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String position,
        @RequestParam(required = false) String nation){
            if(team != null && position!=null){
                return playerService.getPlayerByTeamAndPos(team,position);
            } else if(team != null){
                return playerService.getPlayerByTeam(team);
            } else if(name != null){
                return playerService.getPlayerByName(name);
            } else if(nation != null){
                return playerService.getPlayerByNation(nation);
            } else if(position != null){
                return playerService.getPlayerByPos(position);
            }else{
                System.out.println("a");
                return playerService.getPlayers();              
            }
        }
    
    @PostMapping("/post")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/put")
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player resultPlayer = playerService.updatePlayer(player);
        if(resultPlayer != null){
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
        }else{ 
            return new ResponseEntity<>(resultPlayer, HttpStatus.NOT_FOUND);
        }     
    }

    @DeleteMapping("/delete/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName){
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player Deleted Successfully", HttpStatus.OK);
    }
}
