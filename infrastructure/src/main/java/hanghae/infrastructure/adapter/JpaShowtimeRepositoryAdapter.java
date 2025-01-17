package hanghae.infrastructure.adapter;

import hanghae.domain.domain.Showtime;
import hanghae.domain.entity.ShowtimeEntity;
import hanghae.domain.port.ShowtimeRepository;
import hanghae.infrastructure.repository.JpaShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaShowtimeRepositoryAdapter implements ShowtimeRepository {

    private final JpaShowtimeRepository jpaShowtimeRepository;

    @Override
    public List<Showtime> findShowtimeByMovieId(Long movieId) {
        return jpaShowtimeRepository.findShowtimeEntitiesByMovie_MovieId(movieId)
                .stream()
                .map(this::toShowtimeFrom)
                .toList();
    }

    private Showtime toShowtimeFrom(ShowtimeEntity showtimeEntity) {
        return Showtime.from(showtimeEntity);
    }
}
