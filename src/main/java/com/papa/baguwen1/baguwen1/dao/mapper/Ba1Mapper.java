package com.papa.baguwen1.baguwen1.dao.mapper;

import com.papa.baguwen1.baguwen1.dao.pojo.Ba1;
import com.papa.baguwen1.baguwen1.dao.pojo.Ba1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Ba1Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ba1
     *
     * @mbg.generated
     */
    long countByExample(Ba1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ba1
     *
     * @mbg.generated
     */
    int deleteByExample(Ba1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ba1
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ba1
     *
     * @mbg.generated
     */
    int insert(Ba1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ba1
     *
     * @mbg.generated
     */
    int insertSelective(Ba1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ba1
     *
     * @mbg.generated
     */
    List<Ba1> selectByExample(Ba1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ba1
     *
     * @mbg.generated
     */
    Ba1 selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ba1
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Ba1 record, @Param("example") Ba1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ba1
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Ba1 record, @Param("example") Ba1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ba1
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Ba1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ba1
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Ba1 record);
}