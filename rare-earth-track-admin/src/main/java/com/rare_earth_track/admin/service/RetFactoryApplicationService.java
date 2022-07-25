package com.rare_earth_track.admin.service;

import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.mgb.model.RetFactoryApplication;

import java.util.List;

/**
 * The interface Ret factory application service.
 *
 * @author hhoa
 * @date 2022 /7/14
 */
public interface RetFactoryApplicationService {
    List<RetFactoryApplication> listFactoryApplications(PageInfo pageInfo, RetFactoryApplication factoryApplication);

    /**
     * Gets factory applications.
     *
     * @param factoryApplication the factory application
     * @return the factory applications
     */
    List<RetFactoryApplication> getFactoryApplications(RetFactoryApplication factoryApplication);
}
