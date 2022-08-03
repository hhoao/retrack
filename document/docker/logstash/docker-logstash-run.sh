#!/usr/bin/bash

bash -c "
  docker run -itd --tty --name my-logstash --network host --volume /data/elastic/:/data/elastic my-logstash:1.0
"