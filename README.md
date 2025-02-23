# kafka_producer_jmx
Simple project for demonstrating JMX agent installation in a Kafka client.

## Prerequire
1. cd terraform && terraform init
2. terraform plan -out=<plan_name>
3. terraform apply "plan_name"
4. terraform output -raw java_api_key,java_api_secret,python_api_key,python_api_secret
1. Fill up in root .env file instructed like .env.example from terraform outputs includes BOOTSTRAP_SERVERS
2. cd ../kafka_producer_jmx && mvn clean package
3. put the JAR in the jar folder folder

## Run
1. ```Docker compose up --build --force recreate```
2. Add prometheus Datasource
3. Import dashboard.json to 

## Stay tuned
1. Confluent JMX exporter metrics rules for Kafka clients:
https://github.com/confluentinc/jmx-monitoring-stacks/blob/main/shared-assets/jmx-exporter/kafka_client.yml