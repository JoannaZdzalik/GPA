ALTER DATABASE `gpa` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
INSERT INTO OFFERS (title, total_cost, additional_info, valid_for, duration, percentvat) values ('Oferta na robienie rzeczy', 8000,'Chcemy klucze i żeby radio grało', '8 miesiecy', '10 dni roboczych', 23);
INSERT INTO tasks (name, price, offer_id) values ( 'Malowanie elewacji', 3000, 1);
INSERT INTO tasks (name, price, offer_id) values ( 'Usuwanie kabli', 5000, 1);
INSERT INTO tasks (name, price, offer_id) values ( 'Śmianie się', 0 , 1);