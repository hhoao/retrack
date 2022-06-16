package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.PageInfo;
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
     * @param pageInfo@return the list
     */
    List<RetProduct> list(PageInfo pageInfo);

    /**
     * Gets products.
     *
     * @param product the product
     * @return the products
     */
    List<RetProduct> getProducts(RetProduct product);

    /**
     * Delete products.
     *
     * @param product the product
     */
    void deleteProducts(RetProduct product);
}
