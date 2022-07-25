package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetFeedback;
import com.rare_earth_track.mgb.model.RetFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetFeedbackMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetFeedbackExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetFeedbackExample example);

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
    int insert(RetFeedback row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetFeedback row);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetFeedback>
     */
    List<RetFeedback> selectByExampleWithBLOBs(RetFeedbackExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetFeedback>
     */
    List<RetFeedback> selectByExample(RetFeedbackExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetFeedback
     */
    RetFeedback selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetFeedback row, @Param("example") RetFeedbackExample example);

    /**
     * updateByExampleWithBLOBs
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("row") RetFeedback row, @Param("example") RetFeedbackExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetFeedback row, @Param("example") RetFeedbackExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetFeedback row);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param row row
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetFeedback row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetFeedback row);
}