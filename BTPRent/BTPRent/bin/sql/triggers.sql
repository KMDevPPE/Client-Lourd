drop trigger if exists hPart;
delimiter //
create trigger hPart
    before insert on Particulier
    for each row
    begin
    declare nb int (2) ;
    select Max(id_C) into nb from Client;

    if nb is null
        then
            set nb = 0 ;
    else
            set nb = nb + 1 ;
    end if ;
            set new.id_C = nb ;

            insert into client
            values (new.id_C, new.nom_C, new.prenom_C, new.ville_C, new.cp_C, new.rue_C, new.telephone,new.mail, new.mdp);

    end //
delimiter ;

drop trigger if exists hEntr;
delimiter //
create trigger hEntr
    before insert on Entreprise
    for each row
    begin
    declare nb int (2) ;
    select Max(id_C) into nb from Client;

    if nb is null
        then
            set nb = 0 ;
    else
            set nb = nb + 1 ;
    end if ;
            set new.id_C = nb ;

            insert into client
            values (new.id_C, new.nom_C, new.prenom_C, new.ville_C, new.cp_C, new.rue_C, new.telephone,new.mail, new.mdp);

    end //
delimiter ;

drop trigger if exists upPart;
delimiter //
create trigger upPart
    before update on Particulier
    for each row
    begin
        update client
        set nom_C = new.nom_C ,
            prenom_C = new.prenom_C ,
            ville_C = new.ville_C,
            cp_C = new.cp_C,
            rue_C = new.cp_C,
            telephone = new.telephone,
            mail = new.mail,
            mdp = new.mdp
        where id_C = new.id_C;
    end //
delimiter ;

drop trigger if exists upEntr;
delimiter //
create trigger upEntr
    before update on Entreprise
    for each row
    begin
        update client
        set nom_C = new.nom_C ,
            prenom_C = new.prenom_C ,
            ville_C = new.ville_C,
            cp_C = new.cp_C,
            rue_C = new.cp_C,
            telephone = new.telephone,
            mail = new.mail,
            mdp = new.mdp
        where id_C = new.id_C;
    end //
delimiter ;

drop trigger if exists delPart;
delimiter //
create trigger delPart
    after delete on Particulier
    for each row
    begin
        delete from Client
        where id_C = old.id_C;
    end //
delimiter ;
 
drop trigger if exists delEntr;
delimiter //
create trigger delEntr
    after delete on Entreprise
    for each row
    begin
        delete from Client
        where id_C = old.id_C;
    end //
delimiter ;

create view infClient as
    select * , count(id_Cont) as nbContrat , sum (prix) as total
    from client c , contrat co, materiel m
    where c.id_C = co.id_C ,
    and m.id_M = co.id_M;
