package hanghae.domain.entity;

import hanghae.domain.common.movie.*;
import hanghae.domain.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@NoArgsConstructor
public class MovieEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;

    @Enumerated(EnumType.STRING)
    private AgeRating ageRating;

    @Convert(converter = ReleaseDateConverter.class)
    private ReleaseDate releaseDate;

    private String thumbnailUrl;

    @Convert(converter = RunningTimeConverter.class)
    private RunningTime runningTime;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShowtimeEntity> showtime = new ArrayList<>();
}
