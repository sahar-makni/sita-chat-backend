# README


## using docker for MariaDB:

during the project dev, I setup MariaDB using docker:

### Create container:

```
docker run --detach --name sita --env MARIADB_USER=sita --env MARIADB_PASSWORD=sita --env MARIADB_ROOT_PASSWORD=sita  -p 3306:3306 mariadb:latest
```

### Access container shell

```
docker exec -it sita bash
```

### Access MariaDB prompt

```
mysql -u root -p
```

### Add privileges to 'sita' user

```
GRANT ALL privileges ON `sita`.* TO 'sita'@'%' IDENTIFIED BY 'sita';
FLUSH PRIVILEGES;
```

# Importing Data to MariaDB

to explore/use the app immediately, execute the SQL in `db_dump/data_base_sita.sql`.

the following users where created 
(using sahar@gmail.com is recommanded):

| user             | password |
|------------------|----------|
| sahar@gmail.com  | sahar    | 
| jules@gmail.com  | 123      | 
| marie@gmail.com  | 123      |
| pierre@gmail.com | 123      |


# Postman collection 
a postman collection is provided containing all EndPoints in this repo
find it in `postman/sita.postman_collection.json` `postman/sita.postman_environment.json`
