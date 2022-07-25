package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetFeedbackCategory;
import com.rare_earth_track.mgb.model.RetFeedbackCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetFeedbackCategoryMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetFeedbackCategoryExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetFeedbackCategoryExample example);

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
    int insert(RetFeedbackCategory row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetFeedbackCategory row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetFeedbackCategory>
     */
    List<RetFeedbackCategory> selectByExample(RetFeedbackCategoryExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetFeedbackCategory
     */
    RetFeedbackCategory selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetFeedbackCategory row, @Param("example") RetFeedbackCategoryExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetFeedbackCategory row, @Param("example") RetFeedbackCategoryExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetFeedbackCategory row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetFeedbackCategory row);
}