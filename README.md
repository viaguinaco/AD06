# AD06
Tarea UD06 de AD


Escribe una consulta que muestre el nombre, género, y la duración (runtime) de las primeras 10 series
ordenados por runtime y nombre y muéstralo de forma indentada.

db.movies.find({},{"name" : 1, "genres" : 1, "runtime" : 1}).sort({"runtime":1,
"name":1}).pretty().limit(10)


Escribe una consulta que muestre el nombre, el género y la puntuación de las series del género “Fantasy”
(no exclusivamente) y tienen una puntuación superior a 7.

db.movies.find({"genres": "Fantasy", "rating.average":{$gt : 7}},{"name":1,"genres":1,
"rating.average":1}).pretty()


Escribe una consulta que muestre el nombre, el género y la puntuación de las series que tienen una
puntuación entre 9 y 9.5 (ambos incluidos).

db.movies.find({"rating.average": {$gte : 9, $lte: 9.5}},
{"name":1,"genres":1,"rating.average":1}).pretty()


Escribe una consulta que muestre el nombre y el género de las series que tienen como género
exclusivamente Drama y Comedy.

db.movies.find({"genres":["Drama","Comedy"]},{"name":1,"genres":1}).pretty()


Escribe una consulta que muestre el nombre y el género de las series cuyo nombre contiene la cadena
"the" y no es del género Comedy
db.movies.find({"name": {$regex: /the/},"genres":{$ne : "Comedy"}},{"name":1,"genres":1}).pretty()


Escribe una consulta que muestre el nombre y la fecha de estreno (premiered) de las series cuya fecha
de estreno es posterior a 2014-10-01.

db.movies.find({"premiered":{$gt : "2014-10-01"}},{"name":1,"premiered":1}).pretty()


Escribe una consulta que muestre el nombre, la fecha de estreno y el idioma (language) de las series
cuya fecha de estreno se es el año 2006 y que no sean de lengua inglesa.

db.movies.find({"premiered":{$gte : "2006-01-01", $lt : "2007-01-01"}, "language": {$ne :
"English"}},{"name":1,"premiered":1,"language":1}).pretty()


Escribe una consulta que muestre el nombre y el idioma (language) de las series cuya genero no está
definido, ordenado por nombre.

db.movies.find({"genres":{$size : 0}},{"name":1, "language":1}).sort({"name":1}).pretty()


Escribe una consulta que muestre el nombre, y la duración (runtime) de las series que duran 30 minutos o
múltiplos de 30, ordenados de menor a mayor duración y por nombre.

db.movies.find({"runtime":{$mod : [30,0]}},{"name":1,"runtime":1}).sort({"runtime": 1,
"name":1}).pretty()


