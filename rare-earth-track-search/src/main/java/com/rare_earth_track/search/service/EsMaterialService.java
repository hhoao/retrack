package com.rare_earth_track.search.service;

import com.rare_earth_track.search.bean.EsMaterial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author hhoa
 * @date 2022/8/4
 **/

public interface EsMaterialService {
    Page<EsMaterial> search(String queryInfo, Pageable pageRequest);
}
