export REMO_PORT=9999
export REMO_DATABASE_URI="jdbc:postgresql://localhost:5432/momo_records"
export REMO_DATABASE_USER=postgres
export REMO_DATABASE_PWD=postgres
export ENVIRONMENT=local

mvn spring-boot:run
#mvn package

export url = postgres://csrnkhoervazrd:98d0881059afa2e083ba308b4bcdb62f2c87de1f86f89b283ebfa35597e7dd9a@ec2-44-206-89-185.compute-1.amazonaws.com:5432/d27sn2esjb5hs5