create table dislikevuser
(
    userid  bigint not null
        constraint "FK3d8me6ivh0s5ea7exg4vm6hs5"
            references users,
    entryid bigint not null
        constraint "FKroqg9jr84y250ytn0abw9lp2o"
            references entries,
    primary key (entryid, userid)
);

alter table dislikevuser
    owner to postgres;

