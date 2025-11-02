sh build-container.sh

docker compose -p crud-gateway-consul -f docker-compose-crud.dev.yml down -v --remove-orphans
docker compose -p crud-gateway-consul -f docker-compose-crud.dev.yml up --build -d