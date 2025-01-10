package hanghae.domain.entity;

import hanghae.domain.common.theater.ShowtimeCollection;
import hanghae.domain.common.theater.ShowtimeCollectionConverter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theaters")
@NoArgsConstructor
public class TheaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterId;

    private String theaterName;

    @Convert(converter = ShowtimeCollectionConverter.class)
    private ShowtimeCollection showtimeCollection;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TheaterShowtimeEntity> theaterShowtime = new ArrayList<>();

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieTheaterEntity> movieTheater = new ArrayList<>();
}
