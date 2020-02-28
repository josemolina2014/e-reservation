# e-reservation


Ejecución local clean 
```install spring-boot:run```

Creación de imagen docker 
```clean install docker:build```


descarga de la imagen docker de postgreSQL
```
docker pull postgres:9.6.6-alpine
```

Inicialización de la imagen docker 
```docker run -d --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=platzi```

ejecucion de la imagen docker de la aplicación
```docker run -d --name ereservation --add-host=postgres_server:192.168.167.145 -p 8080:8080 josemolina2016/e-reservation-0.0.1:latest```
