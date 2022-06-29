create table todolist(
 id int not null auto_increment,
 content VARCHAR(100),
 createAt datetime,
 primary key (id)
)  ENGINE=MYISAM CHARSET=utf8;