package hanghae.domain.domain;

import hanghae.domain.common.movie.*;
import hanghae.domain.entity.MovieEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Movie {

    private MovieId id;

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
                .id(new MovieId(movieEntity.getMovieId()))
                .title(movieEntity.getTitle())
                .ageRating(movieEntity.getAgeRating())
                .releaseDate(movieEntity.getReleaseDate())
                .thumbnailUrl(movieEntity.getThumbnailUrl())
                .runningTime(movieEntity.getRunningTime())
                .genre(movieEntity.getGenre())
                .build();
    }

    public Long getMovieId() {
        return this.id.getMovieId();
    }

    public Movie setShowtime(List<Showtime> showtimeList) {
        this.showtime = showtimeList;
        return this;
    }
}
