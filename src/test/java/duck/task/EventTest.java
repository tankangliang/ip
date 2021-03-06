package duck.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class EventTest {
    @Test
    public void eventCreated() {
        LocalDate fixedDate = LocalDate.parse("2020-12-12");
        String expectedFormattedDate = fixedDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        Event event = new Event("read book", fixedDate);
        assertEquals(false, event.getDone());
        assertEquals("read book", event.getDescription());
        assertEquals(fixedDate, event.getDate());
        assertEquals(expectedFormattedDate, event.getDateAsString());
        assertEquals("[E]"
                + "[\u2718] read book"
                + " (at: " + expectedFormattedDate + ")", event.getStatus());
    }

    @Test
    public void deadlineCanMarkDone() {
        LocalDate fixedDate = LocalDate.parse("2020-12-12");
        Event event = new Event("read book", fixedDate);
        assertEquals(false, event.getDone());
        event.markDone();
        assertEquals(true, event.getDone());
    }
}
