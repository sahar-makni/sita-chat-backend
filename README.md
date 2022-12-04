for the docker MariaDB:
```
docker run --detach --name some-mariadb --env MARIADB_USER=example-user --env MARIADB_PASSWORD=my_cool_secret --env MARIADB_ROOT_PASSWORD=my-secret-pw  -p 3306:3306 mariadb:latest
```
```
mysql -u root -p
```
```
GRANT ALL privileges ON `sita`.* TO 'sita'@'%' IDENTIFIED BY 'sita';
```
```
FLUSH PRIVILEGES;
```