package hanghae.infrastructure.domain.entity;

import hanghae.domain.domain.Movie;
import hanghae.domain.domain.Showtime;
import hanghae.domain.domain.Theater;
import hanghae.domain.types.showtime.Schedule;
import hanghae.infrastructure.domain.converter.ScheduleConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Setter
    @Convert(converter = ScheduleConverter.class)
    private Schedule schedule;

    @Setter
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieEntity movie;

    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TheaterShowtimeEntity> theaterShowtime = new ArrayList<>();

    // TODO mapstruct 사용하자 -> 엔티티에서 정적 팩토리 메서드 사용하니까 이름이 직관적이지 않음
    public static Showtime showtimeDomainOf(
            ShowtimeEntity showtimeEntity,
            Movie movie,
            List<Theater> theaters
    ) {
        return Showtime.builder()
                .schedule(showtimeEntity.getSchedule())
                .movie(movie)
                .theaters(theaters)
                .build();
    }
}
