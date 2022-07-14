package com.rare_earth_track.portal.service;

import com.rare_earth_track.mgb.model.RetFactory;
import com.rare_earth_track.mgb.model.RetFactoryApplication;
import com.rare_earth_track.mgb.model.RetProduct;
import com.rare_earth_track.portal.bean.PageInfo;

import java.util.List;

/**
 * The interface Ret factory service.
 *
 * @author hhoa
 * @date 2022 /7/14
 */
public interface RetFactoryService {
    /**
     * List list.
     *
     * @param pageInfo     the page info
     * @param factoryParam the factory param
     * @return the list
     */
    List<RetFactory> list(PageInfo pageInfo, RetFactory factoryParam);

    /**
     * Gets factories.
     *
     * @param factoryParam the factory param
     * @return the factories
     */
    List<RetFactory> getFactories(RetFactory factoryParam);

    /**
     * Gets factory by factory id.
     *
     * @param id the id
     * @return the factory by factory id
     */
    RetFactory getFactoryByFactoryId(Long id);

    /**
     * List products list.
     *
     * @param factoryName the factory name
     * @param product     the product
     * @param pageInfo    the page info
     * @return the list
     */
    List<RetProduct> listProducts(String factoryName, RetProduct product, PageInfo pageInfo);

    /**
     * Gets factory by factory name.
     *
     * @param name the name
     * @return the factory by factory name
     */
    RetFactory getFactoryByFactoryName(String name);

    /**
     * Apply settled factory.
     *
     * @param factoryApplication the factory param
     */
    void applySettledFactory(RetFactoryApplication factoryApplication);
}
