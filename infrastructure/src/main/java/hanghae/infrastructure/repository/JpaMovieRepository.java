package hanghae.infrastructure.repository;

import hanghae.domain.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface JpaMovieRepository extends JpaRepository<MovieEntity, Long> {
    Optional<List<MovieEntity>> findMoviesPlayingNow(LocalDate now);
}
