package hanghae.application.service;

import hanghae.application.dto.MovieResponse;
import hanghae.application.port.MovieService;
import hanghae.common.exception.NoContentsException;
import hanghae.domain.domain.Movie;
import hanghae.domain.domain.Showtime;
import hanghae.domain.port.MovieRepository;
import hanghae.domain.port.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final ShowtimeRepository showtimeRepository;

    @Override
    public List<MovieResponse> findMoviesPlaying() {
        List<Movie> movieList = movieRepository.findMoviesPlaying(LocalDateTime.now())
                .orElseThrow(() -> new NoContentsException("movie"));

        return movieList.stream()
                .map(this::saveShowtimeInMoviePlaying)
                .map(MovieResponse::from)
                .toList();
    }

    private Movie saveShowtimeInMoviePlaying(Movie movie) {
        List<Showtime> showtimeList = findShowtimeOfMoviePlaying(movie);
        return movie.setShowtime(showtimeList);
    }

    private List<Showtime> findShowtimeOfMoviePlaying(Movie movie) {
        return showtimeRepository.findShowtimeByMovie(movie);
    }
}
