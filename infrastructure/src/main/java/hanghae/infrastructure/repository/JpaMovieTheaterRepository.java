package hanghae.infrastructure.repository;

import hanghae.infrastructure.domain.entity.MovieTheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaMovieTheaterRepository extends JpaRepository<MovieTheaterEntity, Long> {
    List<MovieTheaterEntity> findMovieTheaterEntitiesByMovie_MovieId(Long movieId);
}
