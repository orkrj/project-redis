package hanghae.api.adapter.inbound;

import hanghae.application.dto.MovieResponse;
import hanghae.application.port.inbound.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/now")
    public ResponseEntity<List<MovieResponse>> getMoviesPlayingNow() {
        return ResponseEntity.ok(movieService.findMoviesPlayingNow());
    }
}
