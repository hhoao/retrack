#!/usr/bin/bash

bash -c "
  docker build -t my-logstash:1.0 -f Dockerfile .
"