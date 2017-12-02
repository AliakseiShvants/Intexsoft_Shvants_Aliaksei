CREATE TABLE public.links
(
    link_id bigint DEFAULT nextval('links_link_id_seq'::regclass) PRIMARY KEY NOT NULL,
    click_amount bytea,
    description varchar(255),
    short_url varchar(255),
    url varchar(255)
);