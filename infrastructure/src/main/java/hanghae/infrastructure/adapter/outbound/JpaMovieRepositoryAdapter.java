package hanghae.infrastructure.adapter.outbound;

import hanghae.domain.domain.Movie;
import hanghae.domain.entity.MovieEntity;
import hanghae.domain.port.outbound.MovieRepository;
import hanghae.infrastructure.repository.JpaMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaMovieRepositoryAdapter implements MovieRepository {

    private final JpaMovieRepository jpaMovieRepository;

    @Override
    public Optional<List<Movie>> findMoviesPlaying(LocalDate now) {
        return jpaMovieRepository.findMoviesPlayingNow(now)
                .map(this::toMovieList);
    }

    private List<Movie> toMovieList(List<MovieEntity> movieEntities) {
        return movieEntities.stream()
                .map(Movie::from)
                .toList();
    }
}
