package hanghae.infrastructure.domain.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "theater_showtime")
@NoArgsConstructor
public class TheaterShowtimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterShowtimeId;

    @ManyToOne
    @JoinColumn(name = "theater_id", nullable = false)
    private TheaterEntity theater;

    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    private ShowtimeEntity showtime;
}
