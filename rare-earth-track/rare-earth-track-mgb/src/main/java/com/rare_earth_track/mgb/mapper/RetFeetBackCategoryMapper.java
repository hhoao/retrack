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
     * @param row row
     * @return int
     */
    int insert(RetFeetBackCategory row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetFeetBackCategory row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetFeetBackCategory row, @Param("example") RetFeetBackCategoryExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetFeetBackCategory row, @Param("example") RetFeetBackCategoryExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetFeetBackCategory row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetFeetBackCategory row);
}