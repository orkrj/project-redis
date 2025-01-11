package hanghae.application.adapter.inbound;

import hanghae.application.dto.MovieResponse;
import hanghae.application.port.inbound.MovieService;
import hanghae.common.exception.NoContentsException;
import hanghae.domain.domain.Movie;
import hanghae.domain.port.outbound.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<MovieResponse> findMoviesPlayingNow() {
        // TODO findAll 같은 공통 로직으로 찾은 다음 stream 으로 필터링하는 방향으로 리팩토링
        List<Movie> movieList = movieRepository.findMoviesPlayingNow(LocalDate.now())
                .orElseThrow(() -> new NoContentsException("movie"));

        return movieList.stream()
                .map(MovieResponse::from)
                .toList();
    }
}
