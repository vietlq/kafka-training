#!/bin/bash -x

docker run --rm -it \
           -p 2181:2181 -p 3030:3030 -p 8081:8081 \
           -p 8082:8082 -p 8083:8083 -p 9092:9092 \
           -e ADV_HOST=127.0.0.1 \
           landoop/fast-data-dev

# docker run --rm -it --net=host landoop/fast-data-dev bash
# kafka-topics --zookeeper 127.0.0.1:2181 --create --topic dummy --partitions 3 --replication-factor 1

kafka-topics --zookeeper 127.0.0.1:2181 --describe --topic dummy

# kafka-console-producer --broker-list 127.0.0.1:9092 --topic dummy

# kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic dummy
# kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic dummy --from-beginning

# kafka-console-consumer --bootstrap-server 127.0.0.1:9092 --topic dummy --consumer-property group.id=group1 --from-beginning
