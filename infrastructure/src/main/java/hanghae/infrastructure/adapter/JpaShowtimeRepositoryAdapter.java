package hanghae.infrastructure.adapter;

import hanghae.domain.domain.Movie;
import hanghae.domain.domain.Showtime;
import hanghae.domain.domain.Theater;
import hanghae.domain.port.ShowtimeRepository;
import hanghae.infrastructure.domain.entity.ShowtimeEntity;
import hanghae.infrastructure.domain.entity.TheaterEntity;
import hanghae.infrastructure.repository.JpaShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaShowtimeRepositoryAdapter implements ShowtimeRepository {

    private final JpaShowtimeRepository jpaShowtimeRepository;

    @Override
    public List<Showtime> findShowtimeByMovie(Movie movie) {
        return jpaShowtimeRepository.findShowtimeEntitiesByMovie_MovieId(movie.getMovieId())
                .stream()
                .map(showtimeEntity -> {
                    Theater theater = findTheaterByShowtime(showtimeEntity);
                    return toShowtime(showtimeEntity, movie, theater);
                })
                .toList();
    }

    private Showtime toShowtime(ShowtimeEntity showtimeEntity, Movie movie, Theater theater) {
        return ShowtimeEntity.showtimeDomainOf(showtimeEntity, movie, theater);
    }

    private Theater findTheaterByShowtime(ShowtimeEntity showtimeEntity) {
        TheaterEntity theaterEntity =
                jpaShowtimeRepository.findTheaterEntityByShowtimeId(showtimeEntity.getShowtimeId());

        return TheaterEntity.toTheaterDomain(theaterEntity);
    }
}
