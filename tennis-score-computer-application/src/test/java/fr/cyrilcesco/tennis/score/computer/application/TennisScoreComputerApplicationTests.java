package fr.cyrilcesco.tennis.score.computer.application;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import fr.cyrilcesco.tennis.score.computer.application.utils.MemoryAppender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TennisScoreComputerApplicationTests {

	private MemoryAppender memoryAppender;

	@BeforeEach
	public void init() {
		Logger logger = (Logger) LoggerFactory.getLogger(TennisScoreComputerApplication.class);
		memoryAppender = new MemoryAppender();
		memoryAppender.setContext((LoggerContext) LoggerFactory.getILoggerFactory());
		logger.addAppender(memoryAppender);
		memoryAppender.start();
	}

	@AfterEach
	public void clean() {
		memoryAppender.reset();
	}

	@Test
	void should_return_empty_log_when_args_null() {
		TennisScoreComputerApplication.main(null);
		assertEquals(0, memoryAppender.getSize());
	}

	@Test
	void should_return_empty_log_when_args_has_just_stringToCompute() {
		TennisScoreComputerApplication.main(new String[]{"ABBA"});
		assertEquals(0, memoryAppender.getSize());
	}

	@Test
	void should_return_empty_log_when_args_has_just_stringToCompute_and_one_player() {
		TennisScoreComputerApplication.main(new String[]{"ABBA", "A"});
		assertEquals(0, memoryAppender.getSize());
	}

	@Test
	void should_return_log_when_args_is_complete() {
		TennisScoreComputerApplication.main(new String[]{"ABBA", "B", "A"});
		assertEquals(1, memoryAppender.getSize());

		String expected = """
				[INFO] Player B : 0 / Player A : 15
				Player B : 15 / Player A : 15
				Player B : 30 / Player A : 15
				Player B : 30 / Player A : 30
				""";

		assertFalse(memoryAppender.search(expected).isEmpty());
	}
}
