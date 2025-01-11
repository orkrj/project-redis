package hanghae.infrastructure.repository;

import hanghae.domain.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface JpaMovieRepository extends JpaRepository<MovieEntity, Long> {
    @Query("SELECT m FROM MovieEntity m " +
            "WHERE m.releaseDate <= :now " +
            "AND (m.deletedAt IS NULL OR m.deletedAt > :now)")
    // 상영 중인 영화 -> release_date <= now <= deleted_at
    Optional<List<MovieEntity>> findMoviesPlayingNow(@Param("now") LocalDate now);
}
