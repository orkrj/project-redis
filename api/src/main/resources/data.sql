-- theaters 테이블에 3개 극장 등록
INSERT INTO theaters (theater_id, theater_name, showtime_collection)
VALUES
    (1, 'Central Theater', NULL),
    (2, 'Star Cinema', NULL),
    (3, 'Moonlight Theater', NULL);

-- movies 테이블: 10개 (release_date를 4개 과거 / 6개 미래로 배분)
INSERT INTO movies (
    movie_id, created_at, updated_at, deleted_at,
    release_date, running_time, thumbnail_url, title,
    age_rating, genre
) VALUES
-- 과거(4개)
(1,  '2025-01-17 00:00:00', '2025-01-17 00:00:00', NULL, '2024-12-25', 110, 'http://example.com/1.jpg',  'Movie 1',  'ALL',    'ACTION'),
(2,  '2025-01-17 00:00:00', '2025-01-17 00:00:00', NULL, '2024-11-10', 120, 'http://example.com/2.jpg',  'Movie 2',  'AGE_12', 'COMEDY'),
(3,  '2025-01-17 00:00:00', '2025-01-17 00:00:00', NULL, '2023-08-01',  90, 'http://example.com/3.jpg',  'Movie 3',  'AGE_15', 'DRAMA'),
(4,  '2025-01-17 00:00:00', '2025-01-17 00:00:00', NULL, '2024-01-16', 105, 'http://example.com/4.jpg',  'Movie 4',  'AGE_19', 'HORROR'),

-- 미래(6개)
(5,  '2025-01-17 00:00:00', '2025-01-17 00:00:00', NULL, '2025-02-01', 130, 'http://example.com/5.jpg',  'Movie 5',  'ALL',    'ANIMATION'),
(6,  '2025-01-17 00:00:00', '2025-01-17 00:00:00', NULL, '2025-03-05', 100, 'http://example.com/6.jpg',  'Movie 6',  'AGE_12', 'SF'),
(7,  '2025-01-17 00:00:00', '2025-01-17 00:00:00', NULL, '2025-05-20', 180, 'http://example.com/7.jpg',  'Movie 7',  'AGE_15', 'ROMANCE'),
(8,  '2025-01-17 00:00:00', '2025-01-17 00:00:00', NULL, '2026-01-17', 150, 'http://example.com/8.jpg',  'Movie 8',  'AGE_19', 'DRAMA'),
(9,  '2025-01-17 00:00:00', '2025-01-17 00:00:00', NULL, '2025-12-25',  95, 'http://example.com/9.jpg',  'Movie 9',  'ALL',    'ACTION'),
(10, '2025-01-17 00:00:00', '2025-01-17 00:00:00', NULL, '2027-06-10', 140, 'http://example.com/10.jpg', 'Movie 10','AGE_15', 'COMEDY');

-- showtimes 테이블: Movie마다 1개씩 (10개)
-- schedule 컬럼은 JSON (ScheduleConverter가 직렬화/역직렬화)
INSERT INTO showtimes (showtime_id, movie_id, schedule)
VALUES
    (1, 1,  '{"startDateTime":"2025-02-10T10:00:00","endDateTime":"2025-02-10T12:00:00","baseDateTime":"2025-01-17T00:00:00"}'),
    (2, 2,  '{"startDateTime":"2025-02-15T14:00:00","endDateTime":"2025-02-15T16:00:00","baseDateTime":"2025-01-17T00:00:00"}'),
    (3, 3,  '{"startDateTime":"2025-02-20T18:00:00","endDateTime":"2025-02-20T20:00:00","baseDateTime":"2025-01-17T00:00:00"}'),
    (4, 4,  '{"startDateTime":"2025-03-01T09:00:00","endDateTime":"2025-03-01T11:00:00","baseDateTime":"2025-01-17T00:00:00"}'),
    (5, 5,  '{"startDateTime":"2025-03-05T13:00:00","endDateTime":"2025-03-05T15:00:00","baseDateTime":"2025-01-17T00:00:00"}'),
    (6, 6,  '{"startDateTime":"2025-04-01T19:00:00","endDateTime":"2025-04-01T21:00:00","baseDateTime":"2025-01-17T00:00:00"}'),
    (7, 7,  '{"startDateTime":"2025-04-10T11:00:00","endDateTime":"2025-04-10T13:00:00","baseDateTime":"2025-01-17T00:00:00"}'),
    (8, 8,  '{"startDateTime":"2025-05-01T10:00:00","endDateTime":"2025-05-01T12:00:00","baseDateTime":"2025-01-17T00:00:00"}'),
    (9, 9,  '{"startDateTime":"2025-06-15T15:00:00","endDateTime":"2025-06-15T17:00:00","baseDateTime":"2025-01-17T00:00:00"}'),
    (10,10, '{"startDateTime":"2025-07-20T08:00:00","endDateTime":"2025-07-20T10:00:00","baseDateTime":"2025-01-17T00:00:00"}');

-- movie_theater 테이블: 영화와 극장 매핑(10개 예시)
INSERT INTO movie_theater (movie_theater_id, movie_id, theater_id)
VALUES
    (1, 1, 1),
    (2, 2, 1),
    (3, 3, 2),
    (4, 4, 2),
    (5, 5, 3),
    (6, 6, 1),
    (7, 7, 1),
    (8, 8, 2),
    (9, 9, 3),
    (10,10,3);

-- theater_showtime 테이블: 특정 극장에 특정 showtime 연결 (10개 예시)
INSERT INTO theater_showtime (theater_showtime_id, theater_id, showtime_id)
VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 2, 3),
    (4, 2, 4),
    (5, 3, 5),
    (6, 1, 6),
    (7, 1, 7),
    (8, 2, 8),
    (9, 3, 9),
    (10,3,10);
