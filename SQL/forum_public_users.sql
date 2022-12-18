create table users
(
    id          bigserial
        primary key,
    create_date timestamp(6),
    name        varchar(100),
    status      varchar(1),
    email       varchar(100),
    photo       varchar(250)
);

alter table users
    owner to postgres;

INSERT INTO public.users (id, create_date, name, status, email, photo) VALUES (4, '2022-12-06 19:52:22.668000', 'Talha Baba', 'A', 'talha.buyukbaba.1234@gmail.com', null);
INSERT INTO public.users (id, create_date, name, status, email, photo) VALUES (5, '2022-12-07 15:33:53.249000', 'emirhan çınar', 'A', 'emirhancinar025@gmail.com', null);
INSERT INTO public.users (id, create_date, name, status, email, photo) VALUES (1, '2022-11-30 15:42:23.000000', 'Ahmet Faruk Alkan', 'A', 'ahmetfarukalkan16@gmail.com', 'https://lh3.googleusercontent.com/a/AEdFTp5ai18nBp-6NTifxgA_l2axQrWOJr50-YGQ4oqr=s96-c');
INSERT INTO public.users (id, create_date, name, status, email, photo) VALUES (3, '2022-12-06 19:39:50.573000', 'Ahmet Faruk Alkan', 'A', 'ahmetfarukalkan08@gmail.com', 'https://lh3.googleusercontent.com/a/AEdFTp4fa5LJTEOw7yLPBwzXYYuKzcjLwD3KgxAZsCDk=s96-c');
