Commands to create and run docker containers (for Windows OS):

docker run -p 5432:5432 --name postgres-db -e POSTGRES_USER=jira -e POSTGRES_PASSWORD=JiraRush -v .\src\main\resources\pgdata:/var/lib/postgresql/data -d postgres
docker run -p 5433:5432 --name postgres-db-test -e POSTGRES_USER=jira -e POSTGRES_PASSWORD=JiraRush -v .\src\test\resources\pgdata-test:/var/lib/postgresql/data -d postgres

Build with test skipping:
mvn clean install -DskipTests

1. Done
2. Done
3. Done
4. Done
5. Done
6. Done