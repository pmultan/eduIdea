
INSERT INTO USER (id, firstname, lastname, username, password, email, isActivated) VALUES
(1, "Lokal", "Adminovsky", "admin", "5f4dcc3b5aa765d61d8327deb882cf99", "multan.peter@gmail.com", 1),
(2, "Lokal", "Userovsky", "user", "5f4dcc3b5aa765d61d8327deb882cf99", "test@test.com", 1);
 
INSERT INTO ROLE VALUES
(1,2,1),
(2,1,2);



INSERT INTO news (id, DateCreated, UserCreated, Title, Text) VALUES
(1,current_timestamp(),1,"First news test", "First news <b>test</b> <br /> Contains HTML formatting."),
(2,current_timestamp(),1,"Second news test", "Second news, TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT TEXT ")