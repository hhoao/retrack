package com.rare_earth_track.admin.service;

import com.rare_earth_track.mgb.model.RetProduct;

import java.util.List;

/**
 * The interface Ret product service.
 *
 * @author hhoa
 * @date 2022 /5/30
 */
public interface RetProductService {
    /**
     * List list.
     *
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the list
     */
    List<RetProduct> list(Integer pageNum, Integer pageSize);
}
