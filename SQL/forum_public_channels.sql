create table channels
(
    id            bigserial
        primary key,
    create_date   timestamp(6),
    name          varchar(100),
    status        varchar(1),
    create_user   bigint
        constraint "FKdwqyx3tmukah4uycg7axlkt87"
            references users,
    photo_address varchar(500)
);

alter table channels
    owner to postgres;

INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (1, '2022-11-30 15:42:56.000000', 'Haberler', 'A', 1, '/img/backgroundPhotos/news.png');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (2, '2022-12-06 14:13:26.000000', 'Siyaset', 'A', 1, '/img/backgroundPhotos/politic.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (8, '2022-12-06 14:16:00.000000', 'Tarih', 'A', 1, '/img/backgroundPhotos/history.png');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (11, '2022-12-06 14:16:06.000000', 'Bilim', 'A', 1, '/img/backgroundPhotos/science.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (18, '2022-12-06 14:18:17.000000', 'Televizyon', 'A', 1, '/img/backgroundPhotos/tv.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (16, '2022-12-06 14:16:11.000000', 'Spor', 'A', 1, '/img/backgroundPhotos/sport.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (4, '2022-12-06 14:13:33.000000', 'Boş Konular', 'A', 1, '/img/backgroundPhotos/trollface.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (7, '2022-12-06 14:13:41.000000', 'Oyunlar', 'A', 1, '/img/backgroundPhotos/games.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (13, '2022-12-06 14:16:08.000000', 'Diziler', 'A', 1, '/img/backgroundPhotos/series.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (5, '2022-12-06 14:13:36.000000', 'Sinema', 'A', 1, '/img/backgroundPhotos/cinema.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (3, '2022-12-06 14:13:29.000000', 'Ekonomi', 'A', 1, '/img/backgroundPhotos/economy.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (14, '2022-12-06 14:16:09.000000', 'Teknoloji', 'A', 1, '/img/backgroundPhotos/technology.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (9, '2022-12-06 14:16:03.000000', 'Müzik', 'A', 1, '/img/backgroundPhotos/music.jpeg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (12, '2022-12-06 14:16:07.000000', 'Edebiyat', 'A', 1, '/img/backgroundPhotos/literature.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (15, '2022-12-06 14:16:10.000000', 'Sosyal Medya', 'A', 1, '/img/backgroundPhotos/social_media.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (17, '2022-12-06 14:16:16.000000', 'Seyahat', 'A', 1, '/img/backgroundPhotos/travel.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (10, '2022-12-06 14:16:04.000000', 'Sorunlar', 'A', 1, '/img/backgroundPhotos/problem.jpg');
INSERT INTO public.channels (id, create_date, name, status, create_user, photo_address) VALUES (6, '2022-12-06 14:13:39.000000', 'Egitim', 'A', 1, '/img/backgroundPhotos/education.jpg');
