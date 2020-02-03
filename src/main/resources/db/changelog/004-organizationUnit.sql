create extension IF NOT EXISTS ltree;

create table organization_unit(
    id serial not null,
    label varchar(50) not null,
    code varchar(30) not null,
    path ltree not null
);

insert into organization_unit (label, code, path) values
('Groupe', 'GRP', 'Groupe'),
('Vente', 'Vente', 'Groupe.Vente'),
('Nord', 'Nord', 'Groupe.Vente.Nord'),
('Lille', 'Lille', 'Groupe.Vente.Nord.Lille'),
('Douai', 'Douai', 'Groupe.Vente.Nord.Douai'),
('Ile de France', 'Idf', 'Groupe.Vente.Idf'),
('Paris', 'PAR', 'Groupe.Vente.Idf.Paris'),
('Saint Denis', 'DEN', 'Groupe.Vente.Idf.SaintDenis'),
('Normandie', 'NOR', 'Groupe.Vente.Normandie'),
('Caen', 'CAE', 'Groupe.Vente.Normandie.Caen');