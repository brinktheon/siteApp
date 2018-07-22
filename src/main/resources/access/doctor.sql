CREATE TABLE public.doctor
(
    doc_id bigint NOT NULL,
    category bigint NOT NULL,
    first_name character varying(25) NOT NULL,
    second_name character varying(25) NOT NULL,
    working_time character varying(25) NOT NULL,
    CONSTRAINT doctor_pkey PRIMARY KEY (doc_id)
)