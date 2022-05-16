package com.rare_earth_track.mgb.mapper;

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
     * @param row row
     * @return int
     */
    int insert(RetSubject row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetSubject row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetSubject row, @Param("example") RetSubjectExample example);

    /**
     * updateByExampleWithBLOBs
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleWithBLOBs(@Param("row") RetSubject row, @Param("example") RetSubjectExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetSubject row, @Param("example") RetSubjectExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetSubject row);

    /**
     * updateByPrimaryKeyWithBLOBs
     * @param row row
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(RetSubject row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetSubject row);
}