package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetSubjectCategory;
import com.rare_earth_track.mgb.model.RetSubjectCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetSubjectCategoryMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetSubjectCategoryExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetSubjectCategoryExample example);

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
    int insert(RetSubjectCategory record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetSubjectCategory record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetSubjectCategory>
     */
    List<RetSubjectCategory> selectByExample(RetSubjectCategoryExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetSubjectCategory
     */
    RetSubjectCategory selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetSubjectCategory record, @Param("example") RetSubjectCategoryExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetSubjectCategory record, @Param("example") RetSubjectCategoryExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetSubjectCategory record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetSubjectCategory record);
}