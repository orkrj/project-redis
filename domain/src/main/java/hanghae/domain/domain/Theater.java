package hanghae.domain.domain;

import hanghae.domain.common.theater.ShowtimeCollection;
import hanghae.domain.entity.TheaterEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Theater {

    private String theaterName;

    private ShowtimeCollection showtimeCollection;

    public static Theater of(String theaterName) {
        return new Theater(theaterName, new ShowtimeCollection());
    }

    public static Theater from(TheaterEntity theaterEntity) {
        return Theater.builder()
                .theaterName(theaterEntity.getTheaterName())
                .showtimeCollection(theaterEntity.getShowtimeCollection())
                .build();
    }
}
