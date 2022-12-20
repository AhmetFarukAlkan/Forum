create table entryvheading
(
    entryid   bigint not null
        constraint "FK3l2dmiqa9l93u31a9efqssron"
            references entries,
    headingid bigint not null
        constraint "FK6mkhfkhjmni119mqy69sggcpr"
            references headings,
    primary key (entryid, headingid)
);

alter table entryvheading
    owner to postgres;

INSERT INTO public.entryvheading (entryid, headingid) VALUES (1, 1);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (81, 1);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (82, 1);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (83, 21);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (6, 21);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (22, 21);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (24, 21);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (25, 1);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (26, 23);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (27, 23);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (30, 26);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (37, 26);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (38, 23);
INSERT INTO public.entryvheading (entryid, headingid) VALUES (80, 1);
