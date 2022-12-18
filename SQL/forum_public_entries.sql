create table entries
(
    id          bigserial
        primary key,
    create_date timestamp(6),
    dislikes    integer,
    likes       integer,
    name        varchar(500),
    status      varchar(1),
    create_user bigint
        constraint "FKo5pfla9hn19hvwyyegnxvhxts"
            references users
);

alter table entries
    owner to postgres;

INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (27, '2022-12-17 12:08:36.945000', 0, 1, 'Artacak gibi duruyor', 'A', 1);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (37, '2022-12-17 13:24:29.327000', 0, 1, 'evde başlar', 'A', 1);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (82, '2022-12-17 17:59:26.240000', 0, 1, 'Ahmet Faruk Alkan dedi:
	Ahmet Faruk Alkan dedi:
		son olay fikrimi oldukça değiştirdi
	Cevap: benimde
Cevap: haklı', 'A', 1);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (26, '2022-12-17 12:08:26.779000', 0, 1, 'Dolar artacak mı?', 'A', 1);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (83, '2022-12-18 15:31:08.790000', 0, 0, 'Ahmet Faruk Alkan dedi:
	31
Cevap: komik değil', 'A', 3);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (25, '2022-12-16 14:35:52.043000', 0, 1, 'son olay fikrimi oldukça değiştirdi', 'A', 1);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (22, '2022-12-15 09:48:06.248000', 0, 0, '31', 'A', 1);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (38, '2022-12-17 15:50:00.276000', 0, 1, 'Böyle giderse evet', 'A', 3);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (24, '2022-12-15 09:58:59.101000', 0, 0, 'emirhan espri yapamıyor', 'A', 1);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (6, '2022-12-13 13:56:42.511000', 0, 0, 'Çok komik bir espriye ihtiyacım var', 'A', 1);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (80, '2022-12-17 17:57:46.669000', 0, 2, 'Ahmet Faruk Alkan dedi:
	son olay fikrimi oldukça değiştirdi
Cevap: benimde', 'A', 1);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (1, '2022-11-30 15:43:39.000000', 0, 2, 'Önemli bir olay.', 'A', 1);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (81, '2022-12-17 17:58:48.206000', 0, 2, 'Ahmet Faruk Alkan dedi:
	Ahmet Faruk Alkan dedi:
		son olay fikrimi oldukça değiştirdi
	Cevap: benimde
Cevap: katılıyorum', 'A', 1);
INSERT INTO public.entries (id, create_date, dislikes, likes, name, status, create_user) VALUES (30, '2022-12-17 12:50:31.243000', 0, 0, 'Eğitim okulda mı başlar yoksa evde mi başlar', 'A', 1);
