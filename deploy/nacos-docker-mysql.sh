docker run -d \
-e MODE=standalone \
-e SPRING_DATASOURCE_PLATFORM=mysql \
-e MYSQL_SERVICE_HOST=host \
-e MYSQL_SERVICE_PORT=3306 \
-e MYSQL_SERVICE_USER=root \
-e MYSQL_SERVICE_PASSWORD=123456 \
-e MYSQL_SERVICE_DB_NAME=nacos \
-e JVM_XMS=512m \
-e JVM_XMX=512m \
-e JVM_XMN=256m \
-p 8848:8848 \
--restart=always \
--name mynacos \
nacos/nacos-server