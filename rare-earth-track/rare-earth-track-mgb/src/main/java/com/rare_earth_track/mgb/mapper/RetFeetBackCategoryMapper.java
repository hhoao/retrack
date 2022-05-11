package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetFeetBackCategory;
import com.rare_earth_track.mgb.model.RetFeetBackCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetFeetBackCategoryMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetFeetBackCategoryExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetFeetBackCategoryExample example);

    /**
     * deleteByPrimaryKey
     * @param id id
     * @return int
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert
     * @param record record
     * @return int
     */
    int insert(RetFeetBackCategory record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetFeetBackCategory record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetFeetBackCategory>
     */
    List<RetFeetBackCategory> selectByExample(RetFeetBackCategoryExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetFeetBackCategory
     */
    RetFeetBackCategory selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetFeetBackCategory record, @Param("example") RetFeetBackCategoryExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetFeetBackCategory record, @Param("example") RetFeetBackCategoryExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetFeetBackCategory record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetFeetBackCategory record);
}