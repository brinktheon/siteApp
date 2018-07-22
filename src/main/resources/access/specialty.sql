CREATE TABLE public.specialty
(
    spec_id bigint NOT NULL,
    name character varying(25) NOT NULL,
    CONSTRAINT specialty_pkey PRIMARY KEY (spec_id)
)