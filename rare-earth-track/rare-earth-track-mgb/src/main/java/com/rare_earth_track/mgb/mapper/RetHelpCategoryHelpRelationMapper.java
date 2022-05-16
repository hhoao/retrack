package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetHelpCategoryHelpRelation;
import com.rare_earth_track.mgb.model.RetHelpCategoryHelpRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetHelpCategoryHelpRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetHelpCategoryHelpRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetHelpCategoryHelpRelationExample example);

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
    int insert(RetHelpCategoryHelpRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetHelpCategoryHelpRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetHelpCategoryHelpRelation>
     */
    List<RetHelpCategoryHelpRelation> selectByExample(RetHelpCategoryHelpRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetHelpCategoryHelpRelation
     */
    RetHelpCategoryHelpRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetHelpCategoryHelpRelation row, @Param("example") RetHelpCategoryHelpRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetHelpCategoryHelpRelation row, @Param("example") RetHelpCategoryHelpRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetHelpCategoryHelpRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetHelpCategoryHelpRelation row);
}