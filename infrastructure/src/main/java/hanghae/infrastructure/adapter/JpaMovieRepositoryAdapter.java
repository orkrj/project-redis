package hanghae.infrastructure.adapter;

import hanghae.domain.domain.Movie;
import hanghae.domain.entity.MovieEntity;
import hanghae.domain.port.MovieRepository;
import hanghae.infrastructure.repository.JpaMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaMovieRepositoryAdapter implements MovieRepository {

    private final JpaMovieRepository jpaMovieRepository;

    @Override
    public Optional<List<Movie>> findMoviesPlaying(LocalDateTime now) {
        return jpaMovieRepository.findMoviesPlaying(now)
                .map(this::toMovieListFrom);
    }

    private List<Movie> toMovieListFrom(List<MovieEntity> movieEntities) {
        return movieEntities.stream()
                .map(Movie::from)
                .toList();
    }
}
