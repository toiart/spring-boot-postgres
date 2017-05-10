CREATE SEQUENCE IF NOT EXISTS public.product_product_id_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;

CREATE TABLE IF NOT EXISTS public.product (
	product_id int4 NOT NULL DEFAULT nextval('product_product_id_seq'::regclass),
	product_name varchar(255) NULL,
	CONSTRAINT product_pkey PRIMARY KEY (product_id)
)
WITH (
	OIDS=FALSE
);