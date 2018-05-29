insert into salarie(ID_S, nom_s, prenom_s, rue_s, cp_s, ville_s, mail, mdp, droits)
values
	(null, 'MOUALEM', 'Yannis', 'Rue de Senlis', '95260', 'Beaumont', 'admin','mo', 'admin');

insert into particulier (id_C,datenaiss,nom_c,prenom_c,ville_c,cp_c,rue_c,telephone,mail,mdp)
values
	(null,'1999-01-21','didier','marc','paris','75007','rue de paris','0606060606','q@q.q','q'),
	(null,curdate(),'moualem','yannis','paris','75003','rue du 3eme','0707070707','y@y.y','y'),
	(null,curdate(),'kamoun','elies','paris','75008','rue par la','0909090909','e@e.e','e');

insert into entreprise
values
	(null,'yannis','truc','01234567891257','moualem','yannis','Paris','95100','rue de pars','0101010101','a@a','a'),
	(null,'logisur','logistique','01234567891257','didier','marc','Argenteuil','95100','rue guy moquet','0101010101','l@l.l','l');

insert into etat
values
	(1,'neuf'),
	(2,'tres bon etat'),
	(3,'bon etat'),
	(4,'mauvais etat'),
	(5,'defectueux');

insert into localisation
values
	(1,'Paris','75017','rue de Paris',2017-01-01,null),
	(2,'Argenteuil','95100','rue Guy Moquet',2017-01-01,null),
	(3,'Colombes','92700','rue du oresident salvador allende',2017-01-01,null),
	(4,'Nanterre','92014','rue de je sais pas',2017-01-01,null);

insert into type_materiel
values
	(1,'Gros Oeuvre'),
	(2,'Poncage'),
	(3,'Electricite'),
	(4,'Nettoyage'),
	(5,'Elevation'),
	(6,'Manutention'),
	(7,'Plomberie');

update particulier
set prenom_C = 'Yannis'
where id_C = 1;

update entreprise
set telephone = '0202020202'
where id_C = 3;

delete from particulier
where id_C = 1;

delete from entreprise
where id_C = 3;
