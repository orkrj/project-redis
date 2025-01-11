package hanghae.domain.entity;

import hanghae.domain.common.showtime.Schedule;
import hanghae.domain.common.showtime.ScheduleConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "showtimes")
@NoArgsConstructor
public class ShowtimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtimeId;

    @Convert(converter = ScheduleConverter.class)
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie;

    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TheaterShowtimeEntity> theaterShowtime = new ArrayList<>();
}
