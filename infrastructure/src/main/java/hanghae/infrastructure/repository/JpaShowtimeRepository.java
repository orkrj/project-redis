package hanghae.infrastructure.repository;

import hanghae.infrastructure.domain.entity.ShowtimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaShowtimeRepository extends JpaRepository<ShowtimeEntity, Long> {
    List<ShowtimeEntity> findShowtimeEntitiesByMovie_MovieId(Long movieId);
}
