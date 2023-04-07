# myBaits-Spring에서 XML Mapper 인식시키기

MyBatis가 XML Mapper를 인식할 수 있도록 applicationContext.xml에 아래와 같이 Mapper의 경로를 추가해준다. 여기서 applicationContext.xml은 sts에서의 root-context.xml파일과 동일한 역할을 수행하고 있다.

# SqlSessionTemplate 설정

MyBatis에서 DAO를 이용하는 경우 SqlSessionTemplate을 이용해 DAO를 구현하기 때문에 DAO인터페이스를 구현하기에 앞서 SqlSessionTemplate설정을 먼저 해줘야한다. DAO작업에서 가장 번거로운 작업은 데이터베이스와 연결을 맺고, 작업이 완료된 후 연결을 close()하는 작업인데 mybatis-spring라이브러리는 이것을 처리할 수 있는 SqlSessionTemplate이라는 클래스를 통해 DB를 연결하고, 종료하는 작업을 처리 할 수있다. SqlSessionTemplate은 SqlSession인터페이스를 구현한 클래스로 기본적인 트랜잭션의 관리나 쓰레드 처리의 안정성을 보장해주고, DB의 연결과 종료를 책임진다.

SqlSessionTemplate설정은 applicationContext.xml에서 SqlSessionFactory를 생성자로 주입해서 아래와 같이 설정해준다.


# DAO인터페이스 구현 클래스 작성
앞서 작성한 MemberDAO인터페이스를 구현하는 클래스를 작성하고, SqlSessionTemplate을 주입받아 사용한다.
<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate" destroy-method="clearCache">
<constructor-arg name="sqlSessionFactory" ref="sqlSessionFactory"/>
</bean>

# Spring에서 Bean등록
MemberDAOImpl에 @Repository애너테이션 설정을 했더라도, 스프링에서 해당 패키지를 스캔하지 않으면 스프링의 빈으로 등록되지 못하기 때문에 아래와 같이applicationContext.xml에 작성을 반드시 해줘야한다.

<context:component-scan base-package="com.doubles.mvcboard"/>

# MyBatis로그(log4jdbc-log4j2)
MyBatis를 사용해 개발을 하다보면 잘못된 SQL이나 잘못된 속성명으로 인해 예외가 발생하는 경우가 있는데, 이러한 경우를 대비해 MyBatis의 로그를 보다 자세히 조사할 수 있도록 설정해주는 것이 좋다. 보다 자세한 로그를 보기 위해서는 log4jdbc-log4j2라이브러리를 추가해준다.
그리고 나서 applicationContext.xml에서 약간의 수정이 필요한데 dataSource설정에서 driverClassName과 url의 value를 아래와 같이 변경해준다.

log4jdbc-log4j2가 제대로 동작하기 위해서는 별도의 로그관련 설정이 추가적으로 필요하다. /src/main/resources의 디렉토리에 log4jdbc.log4j2.properties와 logback.xml파일을 생성해주고, 아래와 같이 코드를 작성해준다.
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator