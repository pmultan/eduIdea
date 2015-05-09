
INSERT INTO USER (id, firstname, lastname, username, password, email, isActivated, activationKey) VALUES
(1, "Lokal", "Adminovsky", "admin", "5f4dcc3b5aa765d61d8327deb882cf99", "admin@admin.com", 1, uuid()),
(2, "Lokal", "Userovsky", "user", "5f4dcc3b5aa765d61d8327deb882cf99", "test@test.com", 1, uuid());
 
INSERT INTO ROLE VALUES
(1,2,1),
(2,1,2);

INSERT INTO news (DateCreated, UserCreated, Title, Text) VALUES
(current_timestamp(),1,"First lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ac mi posuere, placerat sem sed, ultricies mauris. Pellentesque vitae blandit tortor, non vulputate justo. Praesent id est sit amet lorem placerat tristique eget non libero. Fusce ut sodales tortor. Pellentesque ultrices eros id eros fringilla, vel elementum ligula tempor. Nulla quam nunc, volutpat nec ligula ultrices, rutrum sagittis elit. Fusce urna urna, ultricies id sodales et, suscipit ut nisl. Praesent vulputate sem ac est commodo accumsan. Ut pharetra aliquam dolor tristique viverra. Donec in risus sapien. Vestibulum et blandit massa. Praesent in velit vitae mi congue porttitor id et nisi. Morbi nec libero nunc. Etiam ut facilisis mauris. Duis consectetur quam vitae purus lacinia, non sollicitudin tellus ullamcorper. Nam nec arcu ligula."),
(current_timestamp(),1,"Second lorem Ipsum", "Vivamus ut massa sed diam semper vulputate auctor vel odio. Morbi sagittis nulla ut varius dignissim. Mauris elit velit, lobortis vel diam ac, pretium efficitur odio. Fusce nec porttitor ipsum. Phasellus in volutpat arcu. Nunc rhoncus vel sem id tincidunt. Donec iaculis leo a arcu tincidunt, sit amet lobortis leo porttitor."),
(current_timestamp(),1,"Third lorem Ipsum", "Nunc leo augue, rhoncus sed ligula id, fermentum volutpat nulla. Praesent hendrerit ligula mi, eu accumsan nisi bibendum vel. Donec consectetur, nibh sit amet posuere imperdiet, nulla sem mollis diam, auctor auctor ante nibh ut ipsum. Nulla bibendum nisi nisl, at condimentum elit malesuada dictum. Donec dolor ante, tristique a enim sit amet, commodo laoreet dolor. Nulla libero ligula, mattis sit amet tristique quis, auctor eget purus. Etiam hendrerit ac ipsum in ultrices. Pellentesque volutpat convallis leo. Nulla rutrum tellus eget urna hendrerit finibus. Praesent lectus urna, tempus at lectus nec, viverra mollis ex. Integer eget accumsan dolor, non porttitor neque."),
(current_timestamp(),1,"Fourth lorem Ipsum", "Nunc leo augue, rhoncus sed ligula id, fermentum volutpat nulla. Praesent hendrerit ligula mi, eu accumsan nisi bibendum vel. Donec consectetur, nibh sit amet posuere imperdiet, nulla sem mollis diam, auctor auctor ante nibh ut ipsum. Nulla bibendum nisi nisl, at condimentum elit malesuada dictum. Donec dolor ante, tristique a enim sit amet, commodo laoreet dolor. Nulla libero ligula, mattis sit amet tristique quis, auctor eget purus. Etiam hendrerit ac ipsum in ultrices. Pellentesque volutpat convallis leo. Nulla rutrum tellus eget urna hendrerit finibus. Praesent lectus urna, tempus at lectus nec, viverra mollis ex. Integer eget accumsan dolor, non porttitor neque."),
(current_timestamp(),1,"Fifth lorem Ipsum", "Nunc leo augue, rhoncus sed ligula id, fermentum volutpat nulla. Praesent hendrerit ligula mi, eu accumsan nisi bibendum vel. Donec consectetur, nibh sit amet posuere imperdiet, nulla sem mollis diam, auctor auctor ante nibh ut ipsum. Nulla bibendum nisi nisl, at condimentum elit malesuada dictum. Donec dolor ante, tristique a enim sit amet, commodo laoreet dolor. Nulla libero ligula, mattis sit amet tristique quis, auctor eget purus. Etiam hendrerit ac ipsum in ultrices. Pellentesque volutpat convallis leo. Nulla rutrum tellus eget urna hendrerit finibus. Praesent lectus urna, tempus at lectus nec, viverra mollis ex. Integer eget accumsan dolor, non porttitor neque.");

INSERT INTO Category (name, parentCategory_id) VALUES
("Výška", null),
("Stredná", null),
("Základka", null),
("Telesná", 3),
("Iné", 3),
("Informačné technológie", 3),
("Iné", 1),
("Biológia", 2),
("Telesná", 2),
("Iné", 2),
("Informačné technológie", 2),
("Matematika", 2);

INSERT INTO Idea(text, title, expectedVotes, complexityLvl, author_id, dateCreated, category_id) VALUES
("Tak som si vsimol ze toto je napicu a vobec to nedava zmysel lebo tamto a hento a ak by to bolo tak a onak tak neni problem.", "Moj napad 1", 20, 1, 1, current_timestamp(), 1),
("Tak som si vsimol ze toto je napicu a vobec to nedava zmysel lebo tamto a hento a ak by to bolo tak a onak tak neni problem.", "Moj napad 2", 20, 1, 1, current_timestamp(), 1),
("Tak som si vsimol ze toto je napicu a vobec to nedava zmysel lebo tamto a hento a ak by to bolo tak a onak tak neni problem.", "Moj napad 3", 20, 1, 1, current_timestamp(), 2),
("Tak som si vsimol ze toto je napicu a vobec to nedava zmysel lebo tamto a hento a ak by to bolo tak a onak tak neni problem.", "Moj napad 4", 20, 1, 1, current_timestamp(), 2),
("Tak som si vsimol ze toto je napicu a vobec to nedava zmysel lebo tamto a hento a ak by to bolo tak a onak tak neni problem.", "Moj napad 5", 20, 1, 1, current_timestamp(), 3),
("Tak som si vsimol ze toto je napicu a vobec to nedava zmysel lebo tamto a hento a ak by to bolo tak a onak tak neni problem.", "Moj napad 6", 20, 1, 1, current_timestamp(), 3);