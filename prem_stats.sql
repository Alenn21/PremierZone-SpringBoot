PGDMP         .            
    |         
   prem_stats    15.4    15.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    28164 
   prem_stats    DATABASE     �   CREATE DATABASE prem_stats WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Colombia.1252';
    DROP DATABASE prem_stats;
                postgres    false            �            1259    28169    player_statistic    TABLE     �  CREATE TABLE public.player_statistic (
    name character varying(255) NOT NULL,
    age integer,
    ast double precision,
    crdr double precision,
    crdy double precision,
    gls double precision,
    min double precision,
    mp integer,
    nation character varying(255),
    pk double precision,
    pos character varying(255),
    starts integer,
    team character varying(255),
    xag double precision,
    xg double precision
);
 $   DROP TABLE public.player_statistic;
       public         heap    postgres    false            �          0    28169    player_statistic 
   TABLE DATA           |   COPY public.player_statistic (name, age, ast, crdr, crdy, gls, min, mp, nation, pk, pos, starts, team, xag, xg) FROM stdin;
    public          postgres    false    214   +       e           2606    28175 &   player_statistic player_statistic_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.player_statistic
    ADD CONSTRAINT player_statistic_pkey PRIMARY KEY (name);
 P   ALTER TABLE ONLY public.player_statistic DROP CONSTRAINT player_statistic_pkey;
       public            postgres    false    214            �   �  x��T�n�0=S_�/0lYr�c�nŊz�u�][K(R ����ٱ�������v�:��
)=��=����\B&�2�C"A�DS�����"g5���31p����U�D�p6�w���A�'�W�[��k��	��-H�щ"���4�y��lWqk|g�IF��46Ը?ض���B��<�⾷7��F��N��L�:bk��_�J�B_�LK3���L�o��4Y��n{�@*����2˝u��S���Gj�o��%ŕo��+\�!�Ԃ9Ӱ2��9z3aF>��gU�m�K� $I��Tm��i+@�4t6������,!'��po�&Bpg��X���=� M|i��
��U(�1���Ŧ�.wƵ���\�n\ ����!��A��=6!�=�v�V�[�}�M�[cl��x}�/g�Vqa��Ҳ�4�,�F�7�l�`��� bJ�����;����/�pչ�sG<�Y֞0J�4AO�����J6�d�0�g�V�M�ݾ�S7��������Л�=�)��up�hϻs��G<Pn��Y���E�䞋3�6��6Y*^�7�IX��u���T�����a��hRvX��=�W{d��x��&s��ك��4�5�RΞ-x;��K>��3~��a��#�$B��\5�     