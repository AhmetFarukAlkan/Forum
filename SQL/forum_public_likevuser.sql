create table likevuser
(
    userid  bigint not null
        constraint "FKkl7mmw82sw3f5ch8j7pxb47ft"
            references users,
    entryid bigint not null
        constraint "FK7yoen9flknipk2a0wvoftuv59"
            references entries,
    primary key (entryid, userid)
);

alter table likevuser
    owner to postgres;

INSERT INTO public.likevuser (userid, entryid) VALUES (3, 80);
INSERT INTO public.likevuser (userid, entryid) VALUES (1, 38);
INSERT INTO public.likevuser (userid, entryid) VALUES (1, 26);
INSERT INTO public.likevuser (userid, entryid) VALUES (1, 27);
INSERT INTO public.likevuser (userid, entryid) VALUES (3, 37);
INSERT INTO public.likevuser (userid, entryid) VALUES (1, 81);
INSERT INTO public.likevuser (userid, entryid) VALUES (3, 1);
INSERT INTO public.likevuser (userid, entryid) VALUES (1, 25);
INSERT INTO public.likevuser (userid, entryid) VALUES (3, 82);
INSERT INTO public.likevuser (userid, entryid) VALUES (3, 81);
INSERT INTO public.likevuser (userid, entryid) VALUES (1, 80);
INSERT INTO public.likevuser (userid, entryid) VALUES (1, 1);
