package com.rare_earth_track.portal.service;

import com.rare_earth_track.mgb.model.RetGbReference;
import com.rare_earth_track.portal.bean.PageInfo;

import java.util.List;

/**
 * @author hhoa
 * @date 2022/7/14
 **/

public interface RetGbReferenceService {

    /**
     * 通过牌号查询国标参考信息
     * @param standardNumber
     * @return RetGbReference
     */
    RetGbReference getGbReferenceByStandardNumber(String standardNumber);

    /**
     * 分页获取国标参考信息
     *
     * @param pageInfo
     * @param gbReference
     * @return list
     */
    List<RetGbReference> listGbReference(PageInfo pageInfo, RetGbReference gbReference);
}
