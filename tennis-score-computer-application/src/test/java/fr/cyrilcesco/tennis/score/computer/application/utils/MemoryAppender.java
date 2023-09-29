package fr.cyrilcesco.tennis.score.computer.application.utils;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

import java.util.List;
import java.util.stream.Collectors;


public class MemoryAppender extends ListAppender<ILoggingEvent> {
    public void reset() {
        this.list.clear();
    }

    public List<ILoggingEvent> search(String string) {
        return this.list.stream()
                .filter(event -> event.toString().contains(string))
                .collect(Collectors.toList());
    }

    public int getSize() {
        return this.list.size();
    }
}