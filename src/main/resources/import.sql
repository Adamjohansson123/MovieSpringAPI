INSERT INTO franchise (name, description) VALUES ('Batman Franchise', 'The adventures of Bruce Wayne as Batman');
INSERT INTO franchise (name, description) VALUES ('Spider-Man', 'The adventures of Peter Parker as Spider-Man');
INSERT INTO franchise (name, description) VALUES ('Star Wars', 'The franchise of Star Wars in a galaxy far far away');

INSERT INTO movie (title, genre, year, director, picture, trailer) VALUES ('Batman The Dark Knight Rises','Action',2008,'Christopher Nolan','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSimysnJBQpFV7uvj-OhCr4oBN6_BTHUqq21Q&usqp=CAU','https://www.youtube.com/watch?v=EXeTwQWrcwY');
INSERT INTO movie (title, genre, year, director, picture, trailer) VALUES ('Spider-man','Action',2002,'Sam Raimi','https://img.gfx.no/2335/2335667/Marvels%20Spider-Man_20180828192752.1000x564.png','https://www.youtube.com/watch?v=Lko8OP9_AjQ');
INSERT INTO movie (title, genre, year, director, picture, trailer) VALUES ('Star Wars: Episode VI – Return of the Jedi','Sci-Fi',1983,'Richard Marquand','https://upload.wikimedia.org/wikipedia/en/b/b2/ReturnOfTheJediPoster1983.jpg','https://www.youtube.com/watch?v=5UfA_aKBGMc');

INSERT INTO character (name, alias, gender, picture) VALUES ('Bruce Wayne','Batman','Male','https://m.media-amazon.com/images/M/MV5BMTkxMzk4MjQ4MF5BMl5BanBnXkFtZTcwMzExODQxOA@@._V1_UX214_CR0,0,214,317_AL_.jpg');
INSERT INTO character (name, alias, gender, picture) VALUES ('Jack Napier','The Joker','Male','https://i.guim.co.uk/img/media/fbb1974c1ebbb6bf4c4beae0bb3d9cb93901953c/10_7_2380_1428/master/2380.jpg?width=1200&height=900&quality=85&auto=format&fit=crop&s=2813a4b0cc5e18aa2ba9e8ecb0297952');
INSERT INTO character (name, alias, gender, picture) VALUES ('Selina Kyle','Catwoman','Female','https://static.posters.cz/image/1300/plakater/batman-dark-knight-rises-catwoman-i12732.jpg');
INSERT INTO character (name, alias, gender, picture) VALUES ('Peter Parker','Spider-Man','Male','https://img.redbull.com/images/c_crop,x_459,y_0,h_1007,w_1174/c_fill,w_650,h_540/q_auto,f_auto/redbullcom/2018/08/29/aa45cdd2-63a7-46d8-a49b-b5d8844a6025/september-spiderman-lead');
INSERT INTO character (name, alias, gender, picture) VALUES ('Norman Osborn','Green Goblin','Male','https://imgix.bustle.com/uploads/image/2021/6/21/1be29fe1-87dd-4cdb-be1e-31e3058c7f48-f92adea5-df38-4b28-9303-f9d9992a38f7-green-goblin-willem-dafoe.jpeg?w=853&h=640&fit=min&auto=format%2Ccompress&q=50&dpr=2');
INSERT INTO character (name, alias, gender, picture) VALUES ('Mary Jane Watson','No Alias','Female','https://static.wikia.nocookie.net/spiderman-films/images/8/85/Mary_Jane_Watson_%28Kirsten_Dunst%29.jpg/revision/latest?cb=20210601233728');
INSERT INTO character (name, alias, gender, picture) VALUES ('Luke Skywalker','No alias','Male','https://upload.wikimedia.org/wikipedia/en/9/9b/Luke_Skywalker.png');
INSERT INTO character (name, alias, gender, picture) VALUES ('Anakin Skywalker','Darth Vader','Male','https://cine.no/wp-content/uploads/2020/11/Darth-Vader.jpeg');
INSERT INTO character (name, alias, gender, picture) VALUES ('Leia Organa','No alias','Female','https://lthumb.lisimg.com/889/7153889.jpg?width=411&sharpen=true');

INSERT INTO character_movie (movie_id, character_id) VALUES (1,1);
INSERT INTO character_movie (movie_id, character_id) VALUES (1,2);
INSERT INTO character_movie (movie_id, character_id) VALUES (1,3);
INSERT INTO character_movie (movie_id, character_id) VALUES (2,4);
INSERT INTO character_movie (movie_id, character_id) VALUES (2,5);
INSERT INTO character_movie (movie_id, character_id) VALUES (2,6);
INSERT INTO character_movie (movie_id, character_id) VALUES (3,7);
INSERT INTO character_movie (movie_id, character_id) VALUES (3,8);
INSERT INTO character_movie (movie_id, character_id) VALUES (3,9);



