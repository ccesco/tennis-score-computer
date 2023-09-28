package fr.cyrilcesco.tennis.score.computer.application;

import fr.cyrilcesco.tennis.score.computer.application.service.ApplicationService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisScoreComputerApplication {

	public static void main(String[] args) {
		ApplicationService service = new ApplicationService();
		if(args.length >= 1) {
			System.out.println(service.getDisplayTennisScoreComputer(args[0], args[1], args[2]));
		}
	}

}
