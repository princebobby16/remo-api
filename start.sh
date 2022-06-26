export REMO_PORT=9999
export REMO_DATABASE_URI="jdbc:postgresql://localhost:5432/momo_records"
export REMO_DATABASE_USER=postgres
export REMO_DATABASE_PWD=postgres
export ENVIRONMENT=local

mvn spring-boot:run
#mvn package