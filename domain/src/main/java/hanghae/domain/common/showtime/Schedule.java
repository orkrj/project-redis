package hanghae.domain.common.showtime;

import hanghae.domain.exception.showtime.InvalidScheduleException;
import lombok.Getter;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Schedule {

    @Getter
    private final LocalDateTime startTime;

    @Getter
    private final LocalDateTime endTime;

    private final LocalDateTime baseTime;

    public Schedule(LocalDateTime startTime, LocalDateTime endTime, Clock clock) throws InvalidScheduleException {
        this.baseTime = LocalDateTime.now(clock);

        isValidSchedule(startTime, endTime, baseTime);

        this.startTime = startTime;
        this.endTime = endTime;
    }

    private LocalDate convertStartTimeToLocalDate() {
        return startTime.toLocalDate();
    }

    private void isValidSchedule(LocalDateTime startTime, LocalDateTime endTime, LocalDateTime baseTime) throws InvalidScheduleException {
        if (startTime.isBefore(baseTime) || endTime.isBefore(baseTime)) {
            throw new InvalidScheduleException(
                    String.format(
                            "schedule start time (%s) or end time (%s) " +
                                    "cannot be in the past (base time: %s).",
                            startTime, endTime, baseTime
                    )
            );
        }

        if (endTime.isBefore(startTime)) {
            throw new InvalidScheduleException("endTime can not be before startTime");
        }
    }

    public void isValidScheduleWithMovieReleaseDate(LocalDate movieReleaseDate) throws InvalidScheduleException {
        LocalDate startDate = convertStartTimeToLocalDate();

        if (startDate.isBefore(movieReleaseDate)) {
            throw new InvalidScheduleException(
                    "schedule start date can not be before movie release date"
            );
        }
    }

    public void isValidScheduleWithMovieRunningTime(int movieRunningTime) throws InvalidScheduleException {
        LocalDateTime calculatedEndTime = startTime.plusMinutes(movieRunningTime);

        if (endTime.isBefore(calculatedEndTime)) {
            throw new InvalidScheduleException(
                    String.format("schedule end time (%s) is before calculated end time (%s).",
                            endTime, calculatedEndTime
                    )
            );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(startTime, schedule.startTime) && Objects.equals(endTime, schedule.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", baseTime=" + baseTime +
                '}';
    }
}
