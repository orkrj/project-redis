package hanghae.domain.entity;

import hanghae.domain.common.showtime.Schedule;
import hanghae.domain.common.showtime.ScheduleConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "showtimes")
public class ShowtimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtimeId;

    @Convert(converter = ScheduleConverter.class)
    private Schedule schedule;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;

    // TODO 다대다 풀기 위해 중간 테이블 필요
    // private TheaterEntity theater;
}
