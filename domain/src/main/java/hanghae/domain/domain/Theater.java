package hanghae.domain.domain;

import hanghae.domain.common.theater.Showtimes;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Theater {

    private String theaterName;

    private Showtimes showtimes;

    public static Theater of(String theaterName) {
        return new Theater(theaterName, new Showtimes());
    }
}
