package hanghae.domain.entity;

import hanghae.domain.common.showtime.Schedule;
import hanghae.domain.common.showtime.ScheduleConverter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "showtimes")
@NoArgsConstructor
public class ShowtimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtimeId;

    @Convert(converter = ScheduleConverter.class)
    private Schedule schedule;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TheaterShowtimeEntity> theaterShowtime = new ArrayList<>();
}
