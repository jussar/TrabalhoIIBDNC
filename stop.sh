mvn clean
docker-compose down

docker rm   appjsforum
docker rm   bdjsforum
docker rmi  jose/jsforumapp
docker rmi  jose/forumb

