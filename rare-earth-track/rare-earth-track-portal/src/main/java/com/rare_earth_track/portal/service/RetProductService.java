package com.rare_earth_track.portal.service;

import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.portal.bean.PageInfo;

import java.util.List;

/**
 * The interface Ret product service.
 *
 * @author hhoa
 * @date 2022 /7/14
 */
public interface RetProductService {
    /**
     * Gets product by batch id.
     *
     * @param batchId the batch id
     * @return the product by batch id
     */
    RetProduct getProductByBatchId(String batchId);

    /**
     * List list.
     *
     * @param product  the product
     * @param pageInfo the page info
     * @return the list
     */
    List<RetProduct> list(RetProduct product, PageInfo pageInfo);

    List<RetProduct> getProducts(RetProduct product, PageInfo pageInfo);
}
