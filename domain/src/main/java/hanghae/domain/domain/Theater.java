package hanghae.domain.domain;

import hanghae.domain.common.theater.ShowtimeCollection;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Theater {

    private String theaterName;

    private ShowtimeCollection showtimeCollection;

    public static Theater of(String theaterName) {
        return new Theater(theaterName, new ShowtimeCollection());
    }
}
