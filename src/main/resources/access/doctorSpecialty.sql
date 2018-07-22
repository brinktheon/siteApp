CREATE TABLE public.doctor_specialty
(
    doctor_id bigint NOT NULL,
    specialty_id bigint NOT NULL,
    CONSTRAINT doctor_pkey FOREIGN KEY (doctor_id)
        REFERENCES public.doctor (doc_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT specialty_pkey FOREIGN KEY (specialty_id)
        REFERENCES public.specialty (spec_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)