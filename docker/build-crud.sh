# /bin/bash
set -e

BASE_DIR=$(cd "$(dirname "$0")" && pwd)

echo "🧱 Gradle build start..."

echo "🚀 Start build crud-get"
cd $BASE_DIR/../backend/core/get && ./gradlew clean build -x test --no-daemon
docker build --no-cache -t crud-get -f dockerfile .
echo "✅ crud-get docker build complete."

echo "🚀 Start build crud-post"
cd $BASE_DIR/../backend/core/post && ./gradlew clean build -x test --no-daemon
docker build --no-cache -t crud-post -f dockerfile .
echo "✅ crud-post docker build complete."

echo "🚀 Start build crud-put"
cd $BASE_DIR/../backend/core/put && ./gradlew clean build -x test --no-daemon
docker build --no-cache -t crud-put -f dockerfile .
echo "✅ crud-put docker build complete."

echo "🚀 Start build crud-delete"
cd $BASE_DIR/../backend/core/delete && ./gradlew clean build -x test --no-daemon
docker build --no-cache -t crud-delete -f dockerfile .
echo "✅ crud-delete docker build complete."

echo "🚀 Start build crud-gateway"
cd $BASE_DIR/../backend/edge/gateway && ./gradlew clean build -x test --no-daemon
docker build --no-cache -t crud-gateway -f dockerfile .
echo "✅ crud-gateway docker build complete."

echo "🎉 All builds complete successfully."