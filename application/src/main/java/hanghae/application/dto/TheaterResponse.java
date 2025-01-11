package hanghae.application.dto;

import hanghae.domain.domain.Theater;

public record TheaterResponse(
        String theaterName
) {

    public static TheaterResponse from(Theater theater) {
        return new TheaterResponse(theater.getTheaterName());
    }
}
