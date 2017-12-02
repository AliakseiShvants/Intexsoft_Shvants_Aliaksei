CREATE TABLE public.tags
(
    tag_id bigint DEFAULT nextval('tags_tag_id_seq'::regclass) PRIMARY KEY NOT NULL,
    title varchar(255),
    id bigint NOT NULL,
    CONSTRAINT fkcdqix8q280ylbeibrk15nlunr FOREIGN KEY (id) REFERENCES links (link_id)
);