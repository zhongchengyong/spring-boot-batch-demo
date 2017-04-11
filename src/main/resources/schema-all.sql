DROP TABLE person IF EXISTS ;
CREATE  TABLE person(
  id INT IDENTITY PRIMARY KEY ,
  first_name VARCHAR(20) ,
  last_name VARCHAR(20)
)