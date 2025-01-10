package hanghae.domain.common.theater;

import hanghae.domain.domain.Showtime;
import hanghae.domain.exception.Theater.InvalidShowtimesException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Showtimes {

    private final List<Showtime> showtimes;

    public Showtimes() {
        this.showtimes = new ArrayList<>();
    }

    public void add(Showtime showtime) {
        // TODO NPE 는 전역 예외 처리하자
        isDuplicate(showtime);
        isOverlapped(showtime);

        showtimes.add(showtime);
    }

    public void remove(Showtime showtime) {
        ensureShowtimeExists(showtime);

        showtimes.remove(showtime);
    }

    public List<Showtime> getShowtimesAsList() {
        return Collections.unmodifiableList(showtimes);
    }

    private void isDuplicate(Showtime showtime) {
        if (showtimes.contains(showtime)) {
            throw new InvalidShowtimesException("showtime already exists");
        }
    }

    private void isOverlapped(Showtime showtime) {
        for (Showtime existing : showtimes) {
            isTargetStartTimeBeforeExistingEndTime(showtime, existing);
            isTargetEndTimeAfterExistingStartTime(showtime, existing);
        }
    }

    private void isTargetStartTimeBeforeExistingEndTime(
            Showtime target, Showtime existing
    ) {

        LocalDateTime targetStartTime = target.getStartTime();
        LocalDateTime existingEndTime = existing.getEndTime();

        if (targetStartTime.isBefore(existingEndTime)) {
            throw new InvalidShowtimesException(
                    String.format(
                            "showtime started at %s overlaps existing showtime ended at %s",
                            targetStartTime, existingEndTime)
            );
        }
    }

    private void isTargetEndTimeAfterExistingStartTime(
            Showtime target, Showtime existing
    ) {
        LocalDateTime targetEndTime = target.getEndTime();
        LocalDateTime existingStartTime = existing.getStartTime();

        if (targetEndTime.isAfter(existingStartTime)) {
            throw new InvalidShowtimesException(
                    String.format(
                            "showtime ended at %s overlaps existing showtime started at %s",
                            targetEndTime, existingStartTime)
            );
        }
    }

    private void ensureShowtimeExists(Showtime showtime) {
        if (!showtimes.contains(showtime)) {
            throw new InvalidShowtimesException(
                    "there are no showtime in showtimes"
            );
        }
    }
}
