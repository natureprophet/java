package main.services;

import main.components.Coach;
import main.components.Player;
import main.components.Position;
import main.components.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamServices {

    public static final int CANTIDAD_DEFENSORES = 4;

    // Instancia de si misma
    private static TeamServices instance = null;

    // Un constructor privado impide instanciar la clase desde afuera
    private TeamServices() {
    }

    // Este método puede ser llamado sin instanciar la clase gracias a que es public y static
    public static TeamServices getInstance() {
        if (instance == null) {
            instance = new TeamServices();
        }
        return instance;
    }

    public double getSkill(Team team) {
        return 0.0;
    }

    public void orderPlayers(Team team) {

    }

    public Team whoWin(Team team1, Team team2) {
        return null;
    }

    public Team getDreamTeam(Team team1, Team team2) {
        // Verificamos que los dos equipos sean validos
        if (team1.validateTeam() && team2.validateTeam()) {

            // Creamos nuestro dream team
            Team dreamTeam = new Team("Dream Team");

            // Buscamos el mejor entrenador posible
            Coach bestCoach;

            if (team1.getCoach().getExperience() >= team2.getCoach().getExperience()) {
                bestCoach = team1.getCoach();
            } else {
                bestCoach = team2.getCoach();
            }

            dreamTeam.contractCoach(bestCoach);

            // Buscamos el mejor arquero
            List<Player> arqueros = new ArrayList<>();
            arqueros.addAll(team1.getPlayers(Position.ARQUERO));
            arqueros.addAll(team2.getPlayers(Position.ARQUERO));

            dreamTeam.contractPlayer(getBetter(arqueros));

            // Formacion usada por ahora 4-4-2

            // Buscamos los 4 mejores defensores
            List<Player> defendores = new ArrayList<>();
            defendores.addAll(team1.getPlayers(Position.DEFENSOR));
            defendores.addAll(team2.getPlayers(Position.DEFENSOR));

            if(defendores.size() < CANTIDAD_DEFENSORES) {
                System.out.println("Necesitamos como minimo 4 defensores en total");
                return null;
            }

            Player bestDefensor;
            for (int i = 0; i < CANTIDAD_DEFENSORES ; i++) {
                bestDefensor = getBetter(defendores);
                dreamTeam.contractPlayer(bestDefensor);
                defendores.remove(bestDefensor);
            }



            List<Player> medios = new ArrayList<>();
            medios.addAll(team1.getPlayers(Position.MEDIO));
            medios.addAll(team2.getPlayers(Position.MEDIO));

            List<Player> delanteros = new ArrayList<>();
            delanteros.addAll(team1.getPlayers(Position.DELANTERO));
            delanteros.addAll(team2.getPlayers(Position.DELANTERO));

            return dreamTeam;

        } else {
            System.out.println("Uno de los equipos no es un equipo valido");
            return null;
        }
    }

    private Player getBetter(List<Player> players) {
        Player bestPlayer = players.get(0);
        for (Player player: players) {
            if(bestPlayer.getSkill() > player.getSkill()) {
                bestPlayer = player;
            } else if(player.getSkill() == bestPlayer.getSkill()) {
                if(player.getAge() > bestPlayer.getAge()) {
                    bestPlayer = player;
                }
            }
        }
        return bestPlayer;
    }
}
