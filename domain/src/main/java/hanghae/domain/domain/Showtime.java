package hanghae.domain.domain;

import hanghae.domain.common.showtime.Schedule;

import java.time.LocalDateTime;

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
        return schedule.getStartTime();
    }

    public LocalDateTime getEndTime() {
        return schedule.getEndTime();
    }
}
