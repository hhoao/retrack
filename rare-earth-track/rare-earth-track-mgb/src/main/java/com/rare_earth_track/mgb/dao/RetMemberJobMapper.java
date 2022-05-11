package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetMemberJob;
import com.rare_earth_track.mgb.model.RetMemberJobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMemberJobMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMemberJobExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMemberJobExample example);

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
    int insert(RetMemberJob record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetMemberJob record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMemberJob>
     */
    List<RetMemberJob> selectByExample(RetMemberJobExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMemberJob
     */
    RetMemberJob selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetMemberJob record, @Param("example") RetMemberJobExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetMemberJob record, @Param("example") RetMemberJobExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetMemberJob record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetMemberJob record);
}