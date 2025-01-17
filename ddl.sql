# -- 영화 테이블
# CREATE TABLE movies (
#                         movie_id BIGINT AUTO_INCREMENT PRIMARY KEY,
#                         title VARCHAR(255) NOT NULL,
#                         age_rating VARCHAR(50) NOT NULL,
#                         release_date DATE NOT NULL,
#                         thumbnail_url VARCHAR(255),
#                         running_time INT NOT NULL,
#                         genre VARCHAR(50) NOT NULL,
#                         created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
#                         updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
#                         deleted_at DATETIME NULL
# );
#
# -- 상영 시간표 테이블
# CREATE TABLE showtimes (
#                            showtime_id BIGINT AUTO_INCREMENT PRIMARY KEY,
#                            schedule JSON NOT NULL,
#                            movie_id BIGINT NOT NULL
# );
#
# -- 극장 테이블
# CREATE TABLE theaters (
#                           theater_id BIGINT AUTO_INCREMENT PRIMARY KEY,
#                           theater_name VARCHAR(255) NOT NULL,
#                           showtime_collection JSON,
#                           created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
#                           updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
#                           deleted_at DATETIME NULL
# );
#
# -- 중간 테이블: 극장-상영 시간표 관계
# CREATE TABLE theater_showtime (
#                                   theater_showtime_id BIGINT AUTO_INCREMENT PRIMARY KEY,
#                                   theater_id BIGINT NOT NULL,
#                                   showtime_id BIGINT NOT NULL
# );
#
# -- 중간 테이블: 영화-극장 관계
# CREATE TABLE movie_theater (
#                                movie_theater_id BIGINT AUTO_INCREMENT PRIMARY KEY,
#                                movie_id BIGINT NOT NULL,
#                                theater_id BIGINT NOT NULL
# );
#
# -- 영화 테이블(더미 데이터)
# INSERT INTO movies (title, age_rating, release_date, thumbnail_url, running_time, genre)
# VALUES
#     ('The Great Adventure', 'PG-13', '2023-01-01', 'http://test.com/thumbnail1', 120, 'Action'),
#     ('Romantic Getaway', 'R', '2023-02-14', 'http://test.com/thumbnail2', 95, 'Romance'),
#     ('Mystery Manor', 'PG', '2023-10-31', 'http://test.com/thumbnail3', 110, 'Mystery');
#
# -- 상영 시간표 테이블(더미 데이터)
# INSERT INTO showtimes (schedule, movie_id)
# VALUES
#     ('{"times": ["10:00", "13:00", "16:00", "20:00"]}', 1),
#     ('{"times": ["11:00", "14:30", "18:00"]}', 2),
#     ('{"times": ["09:30", "12:30", "15:30", "19:30"]}', 3);
#
# -- 극장 테이블(더미 데이터)
# INSERT INTO theaters (theater_name, showtime_collection)
# VALUES
#     ('Downtown Cinema', '{"screen1": "10:00, 13:00", "screen2": "16:00, 20:00"}'),
#     ('Uptown Theater', '{"screen1": "11:00, 14:30", "screen2": "18:00"}'),
#     ('Suburb Multiplex', '{"screen1": "09:30, 12:30", "screen2": "15:30, 19:30"}');
#
# -- 중간 테이블: 극장-상영 시간표 관계(더미 데이터)
# INSERT INTO theater_showtime (theater_id, showtime_id)
# VALUES
#     (1, 1),
#     (2, 2),
#     (3, 3);
#
# -- 중간 테이블: 영화-극장 관계(더미 데이터)
# INSERT INTO movie_theater (movie_id, theater_id)
# VALUES
#     (1, 1),
#     (2, 2),
#     (3, 3);