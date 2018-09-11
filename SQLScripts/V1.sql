CREATE TABLE Notes(
ID int NOT NULL AUTO_INCREMENT,
bg VARCHAR(20),
title VARCHAR(15),
content VARCHAR(255),
creation_date TIMESTAMP,
update_date TIMESTAMP,
active BOOLEAN DEFAULT true,
PRIMARY KEY (ID))

INSERT into Notes(bg,title,content,creation_date,update_date) VALUES (
"bg-warning",
"Title",
"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec suscipit dolor in risus fermentum, a laoreet lorem eleifend. Vestibulum euismod facilisis diam, id luctus quam convallis sed. Donec semper justo a enim laoreet, sit amet consectetur elit amet.",
current_timestamp,
current_timestamp);

