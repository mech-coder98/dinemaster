CREATE TABLE RESTAURANT (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR (300),
    address VARCHAR (300),
    cuisineType VARCHAR (300),
    rating INTEGER
);

CREATE TABLE CHEF (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR (300),
    lastName VARCHAR (300),
    expertise VARCHAR (300),
    experienceYears INTEGER,
    restaurantId INTEGER,

    FOREIGN KEY (restaurantId) REFERENCES RESTAURANT(id)
);