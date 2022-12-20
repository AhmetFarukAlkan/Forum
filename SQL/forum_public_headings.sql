create table headings
(
    id           bigserial
        primary key,
    create_date  timestamp(6),
    name         varchar(100),
    status       varchar(1),
    create_user  bigint
        constraint "FKm5bcesbp6h8utj4m391fl0i3m"
            references users,
    description  varchar(500),
    number_entry integer
);

alter table headings
    owner to postgres;

INSERT INTO public.headings (id, create_date, name, status, create_user, description, number_entry) VALUES (26, '2022-12-17 12:50:31.243000', 'Eğitim nerede başlar', 'A', 1, 'Eğitim okulda mı başlar yoksa evde mi başlar', 2);
INSERT INTO public.headings (id, create_date, name, status, create_user, description, number_entry) VALUES (23, '2022-12-17 12:08:26.779000', 'Dolar', 'A', 1, 'Dolar artacak mı?', 3);
INSERT INTO public.headings (id, create_date, name, status, create_user, description, number_entry) VALUES (1, '2022-11-30 15:43:17.000000', '2023 Seçimleri', 'A', 1, 'Cumhurbaşkanı adil biri olmalı', 5);
INSERT INTO public.headings (id, create_date, name, status, create_user, description, number_entry) VALUES (21, '2022-12-13 13:56:42.511000', 'Espri ', 'A', 1, 'Çok komik bir espriye ihtiyacım var', 4);
