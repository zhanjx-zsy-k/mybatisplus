package com.atguigu.mp.inject;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * @author k
 * @create 2021-09-24 23:34
 */
public class MysqlInject extends AutoSqlInjector {

    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
//        super.inject(configuration, builderAssistant, mapperClass, modelClass, table);
        String sql = "delete from " + table.getTableName();

        String method = "deleteAll";

        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

        this.addDeleteMappedStatement(mapperClass, method, sqlSource);

    }
}
