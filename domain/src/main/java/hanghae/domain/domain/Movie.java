package hanghae.domain.domain;

import hanghae.domain.common.movie.AgeRating;
import hanghae.domain.common.movie.Genre;
import hanghae.domain.common.movie.ReleaseDate;
import hanghae.domain.common.movie.RunningTime;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
public class Movie {

    private String title;

    private AgeRating ageRating;

    private ReleaseDate releaseDate;

    private String thumbnailUrl;

    private RunningTime runningTime;

    private Genre genre;

    public LocalDate getReleaseDateAsLocalDate() {
        return releaseDate.getDate();
    }

    public int getRunningTimeAsMinutes() {
        return runningTime.getMinutes();
    }
}
