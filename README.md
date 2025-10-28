# DevOps-Practice
MSA 설계와 DevOps 연습

## DevOps의 기원과 철학

2000년대 초까지만 하더라도 개발(Dev)은 빠르게 기능 출시, 운영(Ops)은 시스템 안정성 유지라는 서로 다른 목표를 가지고 움직였습니다.

그러다보니, 개발팀과 운영팀간의 마찰이 크게 일어났습니다. 사일로 현상과 잦은 배포 실패가 DevOps의 출발점이 되었습니다.

DevOps는 3가지의 핵심 원칙을 바탕으로 시작합니다.

  1. Flow: 개발 -> 배포 -> 운영의 프로세스를 자동화하여 빠른 피드백 루프 확보
  2. Feedback: 모니터링/로깅/알림 등을 도입하여 운영 피드백을 개발 단계에서 가능하게 함
  3. Continuous Learning: 실패 허용, 지속 개선과 자동화

이러한 DevOps의 철학을 현실로 구현한 기술 스택을 CI/CD 파이프라인(Continuous Integration/Continuous Deployment, 일명 지속 통합/지속 재포)이라고 합니다.

  - CI: 코드 변경 시 자동 테스트/빌드(Jenkins, Github Actions, GitLab CI)
  - CD: 검증된 코드 자동 배포(ArgoCD, Spinnaker, GitOps)
  - Configuration Management: 서버 설정 일관화(Ansible, Chef, Puppet)
  - Containerization: 환경 격리와 이식성 향상(Docker, Podman)
  - Orchestration: 컨테이너 자동 배치(Kubernetes, ECS, Nomad)
  - Monitoring/Loggin: 시스템 관찰 및 피드백(Prometheus, Grafana, ELK(Elasticsearch, Logstash, Kibana), Loki)
  - Infrastructure as Cod(IaC): 인프라 자동 프로비저닝(Terraform, Pulumi, CloudFormation)

DevOps는 GitOps, DevSecOps, AIOps 등으로 확장되었습니다.

Google의 SRE(Site Reliability Engineering)가 DevOps의 확장 개념이기도 합니다.

운영은 개발의 일부고, 코드를 통해 신뢰성을 확보한다가 주된 철학입니다.

현재 트랜드로는, Platform Engineering, GitOps & IaC, Observability & AIOps, FinOps, NoOps(현실적으로는 불가능하나, Serverless와 GitOps로 구체화 중)
