package com.rare_earth_track.portal.service;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.bean.RetProductParam;
import com.rare_earth_track.mgb.model.RetProduct;
import org.springframework.transaction.annotation.Transactional;

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
     * 分页查询某工厂的产品
     * @param pageInfo
     * @param factoryName
     * @return list
     */
    List<RetProduct> listProductByFactory(String factoryName, PageInfo pageInfo);

    /**
     * Gets products.
     *
     * @param product the product
     * @return the products
     */
    List<RetProduct> getProducts(RetProduct product, PageInfo pageInfo);

    /**
     * 添加产品
     *
     * @param productParam 产品参数
     * @return
     */
    @Transactional
    void addProduct(RetProductParam productParam);

    /**
     * 修改产品
     *
     * @param productName the product name
     * @param productParam 产品参数
     */
    @Transactional
    void updateProduct(String productName, RetProductParam productParam);

    /**
     * 删除产品
     *
     * @param name 产品id
     */
    @Transactional
    int deleteProductByName(String name);

    /**
     * Gets product by product name
     *
     * @param name
     * @return the product by product name
     */
    RetProduct getProductByProductName(String name);

    /**
     * Gets product by product id
     *
     * @param id
     * @return the product by product id
     */
    RetProduct getProductByProductId(Long id);

    /**
     * 通过产品批次溯源产品
     * @param batchId
     * @return
     */
    RetProduct getProductByBatchId(String batchId);

    /**
     * Delete products.
     *
     * @param product the product
     */
    void deleteProducts(RetProduct product);
}
