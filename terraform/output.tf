output "java_api_key" {
  value     = confluent_api_key.cluster-java-write-topic-api-key.id
  sensitive = true
}

output "java_api_secret" {
  value     = confluent_api_key.cluster-java-write-topic-api-key.secret
  sensitive = true
}

output "python_api_key" {
  value     = confluent_api_key.cluster-python-write-topic-api-key.id
  sensitive = true
}

output "python_api_secret" {
  value     = confluent_api_key.cluster-python-write-topic-api-key.secret
  sensitive = true
}

output "cluster_bootstrap" {
  value     = confluent_kafka_cluster.bsnir-tf-standard-cluster.bootstrap_endpoint
  sensitive = false
}
