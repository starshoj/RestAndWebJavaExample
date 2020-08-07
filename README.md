build: 
cd restandweb 
gradlew build

run:
gradlew run
or(after build)
java -jar ./build/libs/restandweb-0.0.1-SNAPSHOT.jar


REST endpoint: http://localhost:8080/api/code/{3 letter code}
For example: http://localhost:8080/api/code/EUR

Logs: http://localhost:8080/log
