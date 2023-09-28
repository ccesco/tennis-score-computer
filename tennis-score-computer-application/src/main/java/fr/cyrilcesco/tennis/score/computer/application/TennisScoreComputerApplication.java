package fr.cyrilcesco.tennis.score.computer.application;

import fr.cyrilcesco.tennis.score.computer.application.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TennisScoreComputerApplication {

	private static final Logger logger = LoggerFactory.getLogger(TennisScoreComputerApplication.class);

	public static void main(String[] args) {
		ApplicationService service = new ApplicationService();
		if(args.length >= 1) {
			logger.info(service.getDisplayTennisScoreComputer(args[0], args[1], args[2]));
		}
	}

}
