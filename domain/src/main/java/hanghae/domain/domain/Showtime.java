package hanghae.domain.domain;

import hanghae.domain.common.showtime.Schedule;
import hanghae.domain.entity.ShowtimeEntity;
import lombok.Builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
public class Showtime {

    private Schedule schedule;

    private Movie movie;

    private Theater theater;

    public Showtime(Schedule schedule, Movie movie, Theater theater) {
        this.schedule = schedule;
        this.movie = movie;

        schedule.isValidScheduleWithMovieReleaseDate(movie.getReleaseDateAsLocalDate());
        schedule.isValidScheduleWithMovieRunningTime(movie.getRunningTimeAsMinutes());

        this.theater = theater;
    }

    public LocalDateTime getStartTime() {
        return schedule.getStartDateTime();
    }

    public String getStartTimeAsString() {
        return getFormattedLocalDateTime(getStartTime());
    }

    public LocalDateTime getEndTime() {
        return schedule.getEndDateTime();
    }

    public String getEndTimeAsString() {
        return getFormattedLocalDateTime(getEndTime());
    }

    private String getFormattedLocalDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd:HH:mm");

        return localDateTime.format(formatter);
    }

    public static Showtime from(ShowtimeEntity showtimeEntity) {
        return Showtime.builder()
                .schedule(showtimeEntity.getSchedule())
                .build();
    }
}
