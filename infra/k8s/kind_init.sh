# kind 생성
kind create cluster --config kind-config.yaml

# 클러스터 상태 확인
kubectl cluster-info --context kind-kind

# helm 레포지토리에 ingress 추가
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update

# ingress 설치
helm install ingress-nginx ingress-nginx/ingress-nginx \
  --namespace ingress-nginx --create-namespace \
  --set controller.hostNetwork=true \
  --set controller.nodeSelector."ingress-ready"=true

# helm 생성
helm create practice

# test 파일 삭제
rm -rf practice/templates/tests

# Kind 내부에 이미지 전송
kind load docker-image sample-backend:latest

# 차트 유효성 검사
helm lint ./practice

# 배포
helm install practice-dev ./practice 