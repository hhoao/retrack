package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetPermission;
import com.rare_earth_track.mgb.model.RetPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetPermissionMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetPermissionExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetPermissionExample example);

    /**
     * deleteByPrimaryKey
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert
     * @param row row
     * @return int
     */
    int insert(RetPermission row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetPermission row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetPermission>
     */
    List<RetPermission> selectByExample(RetPermissionExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetPermission
     */
    RetPermission selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetPermission row, @Param("example") RetPermissionExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetPermission row, @Param("example") RetPermissionExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetPermission row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetPermission row);
}