package fr.cyrilcesco.tennis.score.computer.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidPlayerNameExceptionTest {

    @Test
    void should_return_message_when_error_created() {
        InvalidPlayerNameException error = new InvalidPlayerNameException("Cyril");

        assertEquals("Invalid player name Cyril", error.getMessage());
    }
}