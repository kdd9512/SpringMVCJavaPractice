package database;

import controller.MybatisJava.beans.myBatisBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MapperInterface {

    @Insert("insert into MVC_test (data1, data2, data3) values (#{data1},#{data2},#{data3})")
    void insert_data(myBatisBean bean);

    @Select("select * from MVC_test")
    List<myBatisBean> select_data();

}
