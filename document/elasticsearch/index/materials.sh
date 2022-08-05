#!/bin/bash
# 删除materials索引
curl -XDELETE --cacert /data/elasticsearch/certs/ca/ca.crt --user elastic "https://localhost:9200/materials"
# 创建materials索引
curl -XPUT --cacert /data/elasticsearch/certs/ca/ca.crt --user elastic \
  "https://localhost:9200/materials" -H 'Content-Type: application/json' -d'
{
    "aliases" : { },
    "mappings" : {
      "properties" : {
        "@timestamp" : {
          "type" : "date"
        },
        "@version" : {
          "type" : "text",
          "fields" : {
            "keyword" : {
              "type" : "keyword",
              "ignore_above" : 256
            }
          }
        },
        "id" : {
              "type" : "long"
        },
        "name" : {
          "type" : "text",
          "analyzer" : "ik_max_word",
          "fields" : {
            "keyword" : {
              "type" : "keyword",
              "ignore_above" : 256
            }
          }
        },
        "content" : {
          "type" : "text",
          "analyzer" : "ik_max_word"
        },
        "description" : {
          "type" : "text",
          "analyzer" : "ik_max_word"
        },
        "title" : {
          "type" : "text",
          "analyzer" : "ik_max_word",
          "fields" : {
            "keyword" : {
              "type" : "keyword",
              "ignore_above" : 256
            }
          }
        }
      }
    }
}'
