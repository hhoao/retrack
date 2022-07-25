package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetHelpCategory;
import com.rare_earth_track.mgb.model.RetHelpCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetHelpCategoryMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetHelpCategoryExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetHelpCategoryExample example);

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
    int insert(RetHelpCategory row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetHelpCategory row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetHelpCategory>
     */
    List<RetHelpCategory> selectByExample(RetHelpCategoryExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetHelpCategory
     */
    RetHelpCategory selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetHelpCategory row, @Param("example") RetHelpCategoryExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetHelpCategory row, @Param("example") RetHelpCategoryExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetHelpCategory row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetHelpCategory row);
}