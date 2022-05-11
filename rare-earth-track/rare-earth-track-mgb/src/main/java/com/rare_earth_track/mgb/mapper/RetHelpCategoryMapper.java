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
     * @param record record
     * @return int
     */
    int insert(RetHelpCategory record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetHelpCategory record);

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
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetHelpCategory record, @Param("example") RetHelpCategoryExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetHelpCategory record, @Param("example") RetHelpCategoryExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetHelpCategory record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetHelpCategory record);
}