create table headingvchannel
(
    channelid bigint not null
        constraint "FKhp5oi33h8fg1af04dudd35f23"
            references channels,
    headingid bigint not null
        constraint "FKmivbhyjhi29ds31mvc47cpfgq"
            references headings,
    primary key (channelid, headingid)
);

alter table headingvchannel
    owner to postgres;

INSERT INTO public.headingvchannel (channelid, headingid) VALUES (1, 1);
INSERT INTO public.headingvchannel (channelid, headingid) VALUES (4, 21);
INSERT INTO public.headingvchannel (channelid, headingid) VALUES (3, 23);
INSERT INTO public.headingvchannel (channelid, headingid) VALUES (6, 26);
