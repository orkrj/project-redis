package hanghae.infrastructure.domain.entity;

import hanghae.domain.domain.Movie;
import hanghae.domain.types.movie.*;
import hanghae.infrastructure.domain.converter.ReleaseDateConverter;
import hanghae.infrastructure.domain.converter.RunningTimeConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "movies")
@NoArgsConstructor
public class MovieEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;

    @Enumerated(EnumType.STRING)
    private AgeRating ageRating;

    @Convert(converter = ReleaseDateConverter.class)
    private ReleaseDate releaseDate;

    private String thumbnailUrl;

    @Convert(converter = RunningTimeConverter.class)
    private RunningTime runningTime;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShowtimeEntity> showtime = new ArrayList<>();

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieTheaterEntity> movieTheater = new ArrayList<>();

    // TODO mapstruct 사용하자 -> 엔티티에서 정적 팩토리 메서드 사용하니까 이름이 직관적이지 않음
    public static Movie toMovie(MovieEntity movieEntity) {
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
}
