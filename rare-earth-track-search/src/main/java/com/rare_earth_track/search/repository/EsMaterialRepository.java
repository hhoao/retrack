package com.rare_earth_track.search.repository;

import com.rare_earth_track.search.bean.EsMaterial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author hhoa
 * @date 2022/8/4
 **/

public interface EsMaterialRepository extends ElasticsearchRepository<EsMaterial, Integer> {
    @Query("""
            {
                "bool": {
                  "should": [
                    {
                      "match": {
                        "name": {
                          "query": "?0",
                          "analyzer": "ik_max_word",
                          "boost": 2
                        }
                      }
                    },
                    {
                      "match": {
                        "title": {
                          "query": "?",
                          "analyzer": "ik_max_word",
                          "boost": 1.5
                        }
                      }
                    },
                    {
                      "match": {
                        "description": {
                          "query": "?0",
                          "analyzer": "ik_max_word",
                          "boost": 1
                        }
                      }
                    },
                    {
                      "match": {
                        "content": {
                          "query": "?0",
                          "analyzer": "ik_max_word",
                          "boost": 0.5
                        }
                      }
                    }
                  ]
                }
              }
            """)
    Page<EsMaterial> search(String queryInfo, Pageable page);
}
