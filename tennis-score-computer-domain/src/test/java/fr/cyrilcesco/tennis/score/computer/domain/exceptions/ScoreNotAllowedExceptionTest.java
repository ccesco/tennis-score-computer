package fr.cyrilcesco.tennis.score.computer.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreNotAllowedExceptionTest {

    @Test
    void should_return_message_when_error_created() {
        ScoreNotAllowedException scoreNotAllowedException = new ScoreNotAllowedException();

        assertEquals("Score not allowed", scoreNotAllowedException.getMessage());
    }
}