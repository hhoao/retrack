package com.rare_earth_track.mgb.mapper;

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
     * @param row row
     * @return int
     */
    int insert(RetMember row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetMember row);

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
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetMember row, @Param("example") RetMemberExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetMember row, @Param("example") RetMemberExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetMember row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetMember row);
}