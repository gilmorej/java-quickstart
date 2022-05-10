# Quickstart Web Application


## MySQL
### Start docker container
```
docker-compose -f mysql-compose.yaml up
```

### Stop and reset
```
docker-compose -f mysql-compose.yaml down -v
```


## Build Application

Unit tests require MySQL to be running.

```
./gradlew clean build
```

Unit Test Output will be an XML file on the file system. For WSL2 you can open the file system like this:
```
wsl-user@DESKTOP:~/DEV/java-quickstart$ explorer.exe .
```

## Run Web Server
```
./gradlew bootRun
```
