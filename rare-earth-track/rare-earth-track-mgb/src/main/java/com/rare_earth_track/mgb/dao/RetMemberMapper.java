package com.rare_earth_track.mgb.dao;

import com.rare_earth_track.mgb.model.RetMember;
import com.rare_earth_track.mgb.model.RetMemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetMemberMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetMemberExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetMemberExample example);

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
    int insert(RetMember record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetMember record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetMember>
     */
    List<RetMember> selectByExample(RetMemberExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetMember
     */
    RetMember selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetMember record, @Param("example") RetMemberExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetMember record, @Param("example") RetMemberExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetMember record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetMember record);
}