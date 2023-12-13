INSERT INTO `eris_db`.`activite`
(`id_activite`,
`nom_activite`,
`date_debut`,
`date_fin`,
`photo_activite`,
`localisation_id`,
`ville_id`,
`thematique_id`,
`cout`)
VALUES
(1,"Roller Derby","2023-03-16","2023-04-16","rollerderby.jpg",1,2,3, 20),
(2,"Osheaga","2023-03-16","2023-04-16","osheaga.jpg",2,3,4, 20),
(3,"Festival Go Vélo","2023-03-16","2023-04-16","festivalgovelo.jpg",3,4,4, 19),
(4,"Randonnée","2023-03-16","2023-04-16","randonnee.jpg",4,5,3, 20),
(5,"Surf indoor","2023-03-16","2023-04-16","surfindoor.jpg",5,6,3, 15),
(6,"Skating","2023-03-16","2023-04-16","skating.jpg",6,7,3, 20),
(7,"Beach Volley","2023-03-16","2023-04-16","beachvolley.jpg",7,8,3, 20),
(8,"Escalade","2023-03-16","2023-04-16","escalade.jpg",8,9,3, 20),
(9,"Skydiving","2023-03-16","2023-04-15","skydiving.jpg",9,10,7, 15),
(10,"Adele concert", "2023-03-16","2023-04-16","adeleconcert.jpg",10,11,7, 20),
(11,"Escape Room", "2023-03-18", "2023-04-18", "escaperoom.jpg", 11, 12, 7, 24),
(12, "Danse", "2023-03-18", "2023-04-16", "danse.jpg", 12, 13, 5, 20),
(13, "Musée du Louvre", "2023-03-17","2023-04-17", "museelouvre.jpg", 13,14,5, 20),
(14, "Visite de dégustation", "2023-06-17", "2023-07-18","visitedegustation.jpg", 14, 15, 6, 21),
(15, "Peinture", "2023-07-18", "2023-09-19", "peinture.jpg", 15, 16, 7, 20);

INSERT INTO `eris_db`.`client`
(`client_id`,
`nom_client`,
`prenom`,
`courriel`,
`password`,
`admin`)
VALUES
(1,"dupont","charles","charlesdupont@gmail.com","Allo123", 1),
(2,"bernard","lucas","lucasb@gmail.com","Bonjour123", 0),
(3,"richard","boris","boris@gmail.com","Bye123", 0);

INSERT INTO `eris_db`.`inscription_activite`
(`id_inscription_activite`,
`date`,
`client_id`,
`activite_id`)
VALUES
(1,"2023-04-15",2,1),
(2,"2023-05-15",2,2),
(3,"2024-05-15",2,3),
(4,"2023-04-15",3,4),
(5,"2023-05-15",3,5),
(6,"2024-05-15",3,6);

INSERT INTO `eris_db`.`localisation`
(`id_localisation`,
`rue`,
`ville`,
`code_postal`,
`numero_adresse`)
VALUES
(1,"rue Bernard","Montreal","H7H31A",412),
(2,"Cedex","Paris","75058",01),
(3,"Unter den Linden","Berlin","10117",35),
(4,"Al Safa St","Dubai","",124),
(5,"Calle del Dr Cortezo","Madrid","28012",8),
(6,"Stadiou","Athenes","10564",52),
(7,"Via Merulana","Rome","00185",17),
(8,"Av. des Frères Abdeslami","Alger","16055",7),
(9,"Connecticut Ave NW","Washington","DC 20036",1001),
(10,"At Meydani","Istanbul","34122 Fatih",10),
(11,"Cnr Eastwood Street","Pretoria","0083",23),
(12,"Sir William Newton St","Port Louis","11328",6),
(13,"Chome-27-9","Tokyo","110-00616",3),
(14,"Rua Inglês de Sousa","Sao Paulo","01546-010",393),
(15,"119th St","Miami","33168",1100);

INSERT INTO `eris_db`.`thematique`
(`id`,
`nom_thematique`)
VALUES
(3,"Sport"),
(4,"Festivals"),
(5,"Musée et Culture"),
(6,"Gastronomie"),
(7,"Diverstissement");

INSERT INTO `eris_db`.`ville`
(`id`,
`nom_ville`,
`photo_ville`)
VALUES
(2,"Montreal", "montreal.jpg"),
(3,"Paris","paris.jpg"),
(4,"Berlin", "berlin.jpg"),
(5,"Dubai", "dubai.jpg"),
(6,"Madrid", "madrid.jpg"),
(7, "Athenes", "athenes.jpg"),
(8,"Rome", "rome.jpg"),
(9,"Alger", "alger.jpg"),
(10,"Washington", "washington.jpg"),
(11,"Istanbul", "istanbul.jpg"),
(12,"Pretoria", "pretoria.jpg"),
(13,"Port Louis", "portlouis.jpg"),
(14,"Tokyo", "tokyo.jpg"),
(15,"Sao Paulo", "saopaulo.jpg"),
(16,"Miami", "miami.jpg");
