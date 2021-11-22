# Container banco

```
$ docker run --rm --name mysql -v mysql:/var/lib/mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=segredo -d mariadb:10.4.13
$ mysql --protocol=tcp -u root -p
```

# No Windows, ao conectar no MySQL
- Se aparecer a mensagem

```
java.lang.RuntimeException: java.sql.SQLException: The server time zone value 'Hora Padr?o de Buenos Aires' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.
```

- Usar JDBC URL a seguir
jdbc:mysql://localhost/curso?useTimezone=true&serverTimezone=UTC