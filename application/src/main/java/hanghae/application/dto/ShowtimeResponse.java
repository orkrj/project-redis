package hanghae.application.dto;

import hanghae.domain.domain.Showtime;

public record ShowtimeResponse(
   String startTime,
   String endTime,
   String theaterName
) {

    public static ShowtimeResponse from(Showtime showtime) {
        return new ShowtimeResponse(
                showtime.getStartTimeAsString(),
                showtime.getEndTimeAsString(),
                showtime.getTheaterName()
        );
    }
}
