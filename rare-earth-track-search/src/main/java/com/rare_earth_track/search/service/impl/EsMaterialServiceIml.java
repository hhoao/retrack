package com.rare_earth_track.search.service.impl;

import com.rare_earth_track.search.bean.EsMaterial;
import com.rare_earth_track.search.repository.EsMaterialRepository;
import com.rare_earth_track.search.service.EsMaterialService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

/**
 * @author hhoa
 * @date 2022/8/4
 **/

@Service
public class EsMaterialServiceIml implements EsMaterialService {
    final EsMaterialRepository esMaterialRepository;
    final ElasticsearchOperations elasticsearchOperations;

    public EsMaterialServiceIml(ElasticsearchOperations elasticsearchOperations,
                                EsMaterialRepository materialRepository) {
        this.elasticsearchOperations = elasticsearchOperations;
        this.esMaterialRepository = materialRepository;
    }

    @Override
    public Page<EsMaterial> search(String queryInfo, Pageable pageRequest) {
        return esMaterialRepository.search(queryInfo, pageRequest);
    }
}
