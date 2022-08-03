FROM logstash:7.17.3
RUN rm -f /usr/share/logstash/pipeline/logstash.conf /usr/share/logstash/config/logstash-sample.conf
RUN echo > /usr/share/logstash/config/logstash.yml
COPY ["mysql-connector-java-8.0.25.jar", "/data/mysql/driver/"]
ADD logstash.conf /usr/share/logstash/pipeline
# ADD logstash.conf /usr/share/logstash/config/logstash.conf