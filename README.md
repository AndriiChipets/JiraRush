1. Done
2. Done
3. Done
4. Done
5. Done
6. Done
7. Done
8. Done
9. Done
# PLease, replace in localhost.env file DB_URL to fallowing configuration:
DB_URL=jdbc:postgresql://172.17.0.2:5432/jira
# In order to create image, please execute following script:
docker build -t jira_img .
# In order to create and run docker container, please execute following script:
docker run -d -p 8081:8080 --name=jira_app jira_img
# URL to check that application is running:
localhost:8081

10. Done
# PLease, replace in localhost.env file DB_URL to fallowing configuration:
DB_URL=jdbc:postgresql://postgres-db:5432/jira
# In order to run docker-compose, please execute following script:
docker-compose --env-file ./localhost.env up -d
# URL to check that application is running:
localhost:8082