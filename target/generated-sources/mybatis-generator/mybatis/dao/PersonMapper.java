package mybatis.dao;

import java.util.List;
import mybatis.model.Person;

public interface PersonMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PERSON
     *
     * @mbg.generated Tue May 19 18:20:00 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PERSON
     *
     * @mbg.generated Tue May 19 18:20:00 EEST 2020
     */
    int insert(Person record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PERSON
     *
     * @mbg.generated Tue May 19 18:20:00 EEST 2020
     */
    Person selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PERSON
     *
     * @mbg.generated Tue May 19 18:20:00 EEST 2020
     */
    List<Person> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PERSON
     *
     * @mbg.generated Tue May 19 18:20:00 EEST 2020
     */
    int updateByPrimaryKey(Person record);
}