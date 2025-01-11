package hanghae.domain.domain;

import hanghae.domain.common.movie.AgeRating;
import hanghae.domain.common.movie.Genre;
import hanghae.domain.common.movie.ReleaseDate;
import hanghae.domain.common.movie.RunningTime;
import hanghae.domain.entity.MovieEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Movie {

    private String title;

    private AgeRating ageRating;

    private ReleaseDate releaseDate;

    private String thumbnailUrl;

    private RunningTime runningTime;

    private Genre genre;

    private List<Showtime> showtime;

    private List<Theater> theater;

    public LocalDate getReleaseDateAsLocalDate() {
        return releaseDate.getDate();
    }

    public int getRunningTimeAsMinutes() {
        return runningTime.getMinutes();
    }

    public static Movie from(MovieEntity movieEntity) {
        return Movie.builder()
                .title(movieEntity.getTitle())
                .ageRating(movieEntity.getAgeRating())
                .releaseDate(movieEntity.getReleaseDate())
                .thumbnailUrl(movieEntity.getThumbnailUrl())
                .runningTime(movieEntity.getRunningTime())
                .genre(movieEntity.getGenre())
                .build();
    }
}
