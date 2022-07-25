package com.rare_earth_track.mgb.mapper;

import com.rare_earth_track.mgb.model.RetGbReference;
import com.rare_earth_track.mgb.model.RetGbReferenceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RetGbReferenceMapper {
    /**
     * countByExample
     * @param example example
     * @return long
     */
    long countByExample(RetGbReferenceExample example);

    /**
     * deleteByExample
     * @param example example
     * @return int
     */
    int deleteByExample(RetGbReferenceExample example);

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
    int insert(RetGbReference row);

    /**
     * insertSelective
     * @param row row
     * @return int
     */
    int insertSelective(RetGbReference row);

    /**
     * selectByExample
     * @param example example
     * @return java.util.List<com.rare_earth_track.mgb.model.RetGbReference>
     */
    List<RetGbReference> selectByExample(RetGbReferenceExample example);

    /**
     * selectByPrimaryKey
     * @param id id
     * @return com.rare_earth_track.mgb.model.RetGbReference
     */
    RetGbReference selectByPrimaryKey(Long id);

    /**
     * updateByExampleSelective
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExampleSelective(@Param("row") RetGbReference row, @Param("example") RetGbReferenceExample example);

    /**
     * updateByExample
     * @param row row
     * @param example example
     * @return int
     */
    int updateByExample(@Param("row") RetGbReference row, @Param("example") RetGbReferenceExample example);

    /**
     * updateByPrimaryKeySelective
     * @param row row
     * @return int
     */
    int updateByPrimaryKeySelective(RetGbReference row);

    /**
     * updateByPrimaryKey
     * @param row row
     * @return int
     */
    int updateByPrimaryKey(RetGbReference row);
}