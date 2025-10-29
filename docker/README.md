# Container Orchestration

dockerfile 등 컨테이너와 오케스트레이션 관련된 파일들을 다룹니다.

## Kind(Kubernetes in Docker)

쿠버네티스 클러스터를 도커 컨테이너로 띄워서 실제 쿠베처럼 배포와 운영을 쉽고 빠르게 할 수 있습니다.
kind 공식 아카이브 : https://kind.sigs.k8s.io/

    # kind 설치(mac용)
    brew install kind

    # kube cluster 생성
    kind create cluster --name <클러스터 이름>

    # cluster 생성 확인
    kubectl get nodes

    # docker compose -> kube yaml로 변환을 위해 kompose설치
    brew install kompose

    # compose를 kind배포용으로 변환
    kompose convert -f <변환할 dokcer compose 파일 이름> --controller deployment --volumes persistentVolumeClaim

    # kind 컨테이너 내부에 compose의 이미지들을 직접 배포하기 위해 빌드(이미 이미지가 있다면 생략 가능)
    docker build -t <이미지 이름:버전> <dockerfile 위치>

    # kind 클러스터에 이미지 로드
    kind load docker-image [이미지:버전 목록] --name <클러스터 이름>

    # kind 클러스터에 배포
    kubectl apply -f <배포용 파일들이 있는 위치>

    # 배포 상태 확인
    kubectl get pods -w

    # 쿠베 파드 확인
    kubectl get svc 

    # 테스트
    kubectl port-forward svc/<파드 이름> <외부 포트:내부 포트>

    # (다른 터미널 또는 api툴 활용)
    curl http://localhost:<외부 포트>