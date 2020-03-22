# Travel Diary / World

A project rebuilt into a SpringBoot project from JEE 8 project.

Hopefully in the end it will be possible to have users list their travel ways around the world.

## Current REST end points:

Using [Insomnia](https://insomnia.rest/ "Insomnia Rest Client") to check that my rest end points are working.

* /city (Type: GET, fetches all cities in the database)
* /city (Type: POST, [Body]("#json-bodies). Adds a new city.)
* /continent (Type: GET, fetches all continents in the database)
* /country (Type: GET, fetches all countries in the database)

---

## Frontend

No frontend planned yet. Feel free to fork and build your own version.

I might do a Angular or Vue frontend one day, but for now, focus is 100% backend.

## SQL

In application.properties, switch `spring.datasource.initialization-mode=never` to
`spring.datasource.initialization-mode=always`. When deploying, tables will be created
and so will the JoinTable be. Then copy paste `country_language.sql` into the 
newly created JoinTable.
If a column is generated on wrong place, easiest is to go to mysql terminal and write:

```alter table <tablename>> MODIFY COLUMN <columnname> <type> AFTER <column>;```

## JSON bodies

```
Add a city
    "Cityname":"String",
    "Population": Integer,
    "Country": String

Returns 200 OK if added.
Returns 406 Not Acceptable if missing parameters
```

## Contact and Licence

It's an open source project. Used official data about population in different cities.

If you want to fork / clone it, feel free. If you want to hazzle about something is wrong,<br>
please don't. This is a project for learning purposes.

Contact details found under profile. 