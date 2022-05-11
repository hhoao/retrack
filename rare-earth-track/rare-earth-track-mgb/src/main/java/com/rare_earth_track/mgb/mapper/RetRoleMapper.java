package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetRole;
import com.rare_earth_track.mgb.model.RetRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetRoleMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetRoleExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetRoleExample example);

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
    int insert(RetRole record);

    /**
     * insertSelective
     * @param record record
     * @return int
     */
    int insertSelective(RetRole record);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetRole>
     */
    List<RetRole> selectByExample(RetRoleExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetRole
     */
    RetRole selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("record") RetRole record, @Param("example") RetRoleExample example);

    /**
     * updateByExample
     * @param record record
     * @param example example
     * @return int
     */
    int updateByExample(@Param("record") RetRole record, @Param("example") RetRoleExample example);

    /**
     * updateByPrimaryKeySelective
     * @param record record
     * @return int
     */
    int updateByPrimaryKeySelective(RetRole record);

    /**
     * updateByPrimaryKey
     * @param record record
     * @return int
     */
    int updateByPrimaryKey(RetRole record);
}