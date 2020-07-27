kubectl apply -f https://download.elastic.co/downloads/eck/1.1.2/all-in-one.yaml
kubectl -n elastic-system logs -f statefulset.apps/elastic-operator
cat <<EOF | kubectl apply -f -
apiVersion: elasticsearch.k8s.elastic.co/v1
kind: Elasticsearch
metadata:
  name: quickstart
spec:
  version: 7.8.0
  nodeSets:
  - name: default
    count: 1
    config:
      node.master: true
      node.data: true
      node.ingest: true
      node.store.allow_mmap: false
EOF
kubectl get elasticsearch