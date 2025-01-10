-- 영화 테이블
CREATE TABLE movies (
                        movie_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        age_rating VARCHAR(50) NOT NULL,
                        release_date DATE NOT NULL,
                        thumbnail_url VARCHAR(255),
                        running_time INT NOT NULL,
                        genre VARCHAR(50) NOT NULL,
                        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                        updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                        deleted_at DATETIME NULL
);

-- 상영 시간표 테이블
CREATE TABLE showtimes (
                           showtime_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           schedule JSON NOT NULL,
                           movie_id BIGINT NOT NULL,
                           FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE CASCADE
);

-- 극장 테이블
CREATE TABLE theaters (
                          theater_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          theater_name VARCHAR(255) NOT NULL,
                          showtime_collection JSON,
                          created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                          updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          deleted_at DATETIME NULL
);

-- 중간 테이블: 극장-상영 시간표 관계
CREATE TABLE theater_showtime (
                                  theater_showtime_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  theater_id BIGINT NOT NULL,
                                  showtime_id BIGINT NOT NULL,
                                  FOREIGN KEY (theater_id) REFERENCES theaters (theater_id) ON DELETE CASCADE,
                                  FOREIGN KEY (showtime_id) REFERENCES showtimes (showtime_id) ON DELETE CASCADE
);

-- 중간 테이블: 영화-극장 관계
CREATE TABLE movie_theater (
                               movie_theater_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               movie_id BIGINT NOT NULL,
                               theater_id BIGINT NOT NULL,
                               FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE CASCADE,
                               FOREIGN KEY (theater_id) REFERENCES theaters (theater_id) ON DELETE CASCADE
);