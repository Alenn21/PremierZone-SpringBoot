package com.premier.premierZone.player;

import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;
    
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        System.out.println("b");
        return playerRepository.findAll();
    }

    public List<Player> getPlayerByTeam(String teamName){
        return playerRepository.findAll().stream()
        .filter(player -> teamName.equals(player.getTeam()))
        .collect(Collectors.toList());
    }

    public List<Player> getPlayerByName(String searchText){
        return playerRepository.findAll().stream()
        .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
        .collect(Collectors.toList());
    }

    public List<Player> getPlayerByPos(String searchText){
        return playerRepository.findAll().stream()
        .filter(player -> player.getPos().toLowerCase().contains(searchText.toLowerCase()))
        .collect(Collectors.toList());
    }
    public List<Player> getPlayerByNation(String searchText){
        return playerRepository.findAll().stream()
        .filter(player -> player.getNation().toLowerCase().contains(searchText.toLowerCase()))
        .collect(Collectors.toList());
    }

    public List<Player> getPlayerByTeamAndPos(String team, String position){
        return playerRepository.findAll().stream()
        .filter(player -> player.getTeam().toLowerCase().contains(team.toLowerCase()) 
        && player.getPos().toLowerCase().contains(position.toLowerCase()))
        .collect(Collectors.toList());
    }

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer){
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());
        if(existingPlayer.isPresent()){
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setNation(updatedPlayer.getNation());
            playerToUpdate.setTeam(updatedPlayer.getTeam());
            playerToUpdate.setPos(updatedPlayer.getPos());
            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }
    @Transactional
    public void deletePlayer(String name){
        playerRepository.deleteByName(name);
    }
}
