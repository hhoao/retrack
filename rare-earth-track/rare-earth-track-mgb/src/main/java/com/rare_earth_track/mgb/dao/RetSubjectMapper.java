package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetSubject;
import com.rare_earth_track.mgb.model.RetSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetSubjectMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetSubjectExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetSubjectExample example);

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
    int insert(RetSubject record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetSubject record);

    /**
     * selectByExampleWithBLOBs
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetSubject>
     */
    List<RetSubject> selectByExampleWithBLOBs(RetSubjectExample example);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetSubject>
     */
    List<RetSubject> selectByExample(RetSubjectExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetSubject
     */
    RetSubject selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetSubject record, @Param("example") RetSubjectExample example);

    /**
     * updateByExampleWithBLOBs
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("record") RetSubject record, @Param("example") RetSubjectExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetSubject record, @Param("example") RetSubjectExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetSubject record);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param record record
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetSubject record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetSubject record);
}