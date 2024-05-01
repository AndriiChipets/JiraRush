Commands to create and run docker containers (for Windows OS):

# Maven commands
- Build with test skipping:
mvn clean install -DskipTests

# Docker commands
- JiraRush Main DB Container run (for Windows)
docker run -p 5432:5432 --name postgres-db -e POSTGRES_USER=jira -e POSTGRES_PASSWORD=JiraRush -v .\src\main\resources\pgdata:/var/lib/postgresql/data -d postgres
- JiraRush Test DB Container run (for Windows), used to test before migration to H2 embedded DB
docker run -p 5433:5432 --name postgres-db-test -e POSTGRES_USER=jira -e POSTGRES_PASSWORD=JiraRush -v .\src\test\resources\pgdata-test:/var/lib/postgresql/data -d postgres
- JiraRush Server Image build
docker build -t jira_img .
- JiraRush Server Container run
docker run -d -p 8081:8080 --name=jira_app jira_img

# Docker DB connection 
IP: 172.17.0.2
# Dockerfile jira_app container host
localhost:8081
# Dockerfile + Docker-compose jira_app container host
localhost:8082

docker-compose up -d
docker-compose --env-file ./localhost.env up -d

1. Done
2. Done
3. Done
4. Done
5. Done
6. Done
7. Done
8. Done
9. Done
10. Done