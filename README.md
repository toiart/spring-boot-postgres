# spring-boot-postgres

Docker
Please make sure postgres image has been installed.

docker pull postgres

docker run -d --name postgres -p 5432:5432 postgres

gradle build buildDocker

docker run --name spring-boot-jpa-docker-webapp --link postgres:postgres -p 8080:8080 -d spring-boot-rest-postgres


Run docker compose

docker-compose up -d

docker-compose down
