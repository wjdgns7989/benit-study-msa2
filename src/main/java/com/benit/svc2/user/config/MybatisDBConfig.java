package com.benit.svc2.user.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class MybatisDBConfig {


    // 기본 Mybatis 환경설정
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {

        log.info("*************** Mybatis sqlSessionFactory 초기화 START ***************");

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(datasource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:query/**/*.xml"));     // 쿼리문 위치 설정
        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);                                                         // underscore -> camelCase 자동매핑 사용
        sqlSessionFactoryBean.getObject().getConfiguration().setDefaultExecutorType(ExecutorType.SIMPLE);                                               // ExecutorType.SIMPLE -> 일반모드    ,   ExecutorType.BATCH -> 배치모드

        log.info("*************** Mybatis sqlSessionFactory 초기화 END ***************");

        return (SqlSessionFactory) sqlSessionFactoryBean.getObject();

    }



    // Mybatis SqlSessionTemplate BEAN 설정
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }





    // datasource 설정 (Hikari Connection Pool)
    @Bean(name="dataSource")
    public HikariDataSource dataSource(){

        HikariConfig config = new HikariConfig();

        config.setPoolName("MSA-SVC1 Connection Pool");

        //config.setJdbcUrl("jdbc:oracle:thin:@MSA_high?TNS_ADMIN=oci/Wallet_MSA");             // 기본 jdbc 드라이버 URㅣ 설정
        //config.setDriverClassName("oracle.jdbc.OracleDriver");                                // 기본 jdbc 드라이버 설정
        config.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@MSA_high?TNS_ADMIN=oci/Wallet_MSA");      // DriverSpy 드라이버 URL 설정
        config.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");                     // DriverSpy 드라이버 설정(쿼리 로그출력 시 파라미터 바인딩 된 채로 출력하기위해 사용)

        config.setUsername("ADMIN");
        config.setPassword("!Wjdgns230130");
        config.setConnectionTestQuery("select 1 from dual");
        config.setConnectionInitSql("select 1 from dual");
        config.setMaximumPoolSize(5);
        config.setMinimumIdle(1);
        config.setConnectionTimeout( 5 * 1000 ); // 커넥션 풀 생성 시 타임아웃 시간(ms)
        config.setIdleTimeout(0); // 커넥션풀에서 유휴상태로 남을 수 있는 최대시간 ms (0 : 미사용)
        config.setMaxLifetime(0 * 1000); // 커넥션의 최대 유지시간 ms (0 : 미사용)

        return new HikariDataSource(config);

    }




}