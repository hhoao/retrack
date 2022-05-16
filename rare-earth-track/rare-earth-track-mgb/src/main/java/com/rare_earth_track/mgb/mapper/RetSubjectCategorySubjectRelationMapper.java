package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetSubjectCategorySubjectRelation;
import com.rare_earth_track.mgb.model.RetSubjectCategorySubjectRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetSubjectCategorySubjectRelationMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetSubjectCategorySubjectRelationExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetSubjectCategorySubjectRelationExample example);

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
    int insert(RetSubjectCategorySubjectRelation row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetSubjectCategorySubjectRelation row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetSubjectCategorySubjectRelation>
     */
    List<RetSubjectCategorySubjectRelation> selectByExample(RetSubjectCategorySubjectRelationExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetSubjectCategorySubjectRelation
     */
    RetSubjectCategorySubjectRelation selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetSubjectCategorySubjectRelation row, @Param("example") RetSubjectCategorySubjectRelationExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetSubjectCategorySubjectRelation row, @Param("example") RetSubjectCategorySubjectRelationExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetSubjectCategorySubjectRelation row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetSubjectCategorySubjectRelation row);
}