# kafka_producer_jmx
Simple project for demonstrating JMX agent installation in a Kafka client.

## Installation
1. cd terraform && terraform init
2. terraform plan -out=<plan_name>
3. terraform apply "plan_name"
4. terraform output -raw java_api_key,java_api_secret,python_api_key,python_api_secret
5. Fill up in root the ```.env`` file instructed like .env.example from terraform outputs includes BOOTSTRAP_SERVERS
6. cd ../kafka_producer_jmx && mvn clean package
7. put the JAR in the ```jars``` roots folder
8. cd ../

## Run:
1. ```Docker compose up --build --force recreate```
2. Visit Grafana -> https://localhost:3000 (user:Admin->pass:Admin)
3. Import dashboard.json from dashboard folder

## Stay tuned
1. Confluent JMX exporter metrics rules for Kafka clients:
https://github.com/confluentinc/jmx-monitoring-stacks/blob/main/shared-assets/jmx-exporter/kafka_client.yml

## Tears down
1. Docker compose down
2. cd terraform
3. terraform destroy -> yes 