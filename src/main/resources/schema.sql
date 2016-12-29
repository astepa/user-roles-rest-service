CREATE TABLE public.users
(
    id SERIAL NOT NULL,
    login character varying(255),
    name character varying(255) ,
    password character varying(255)  ,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE public.roles
(
    id SERIAL NOT NULL,
    name character varying(255),
    CONSTRAINT roles_pkey PRIMARY KEY (id)
);

CREATE TABLE public.user_roles
(
    id SERIAL NOT NULL,
    role_id integer NOT NULL,
    user_id integer NOT NULL,
    CONSTRAINT user_roles_pkey PRIMARY KEY (id)
);