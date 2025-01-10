package hanghae.domain.entity;

import hanghae.domain.common.theater.ShowtimeCollection;
import hanghae.domain.common.theater.ShowtimeCollectionConverter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterId;

    private String theaterName;

    @Convert(converter = ShowtimeCollectionConverter.class)
    private ShowtimeCollection showtimeCollection;
}
