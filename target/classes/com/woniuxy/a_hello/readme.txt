1. jdbc hibernate mybatis������
	a. ����Ч��
		hibernate > mybatis > jdbc
	b. �����ٶ�
		jdbc > mybatis > hibernate 

	c. mybatis�ż��ͣ�hibernate�ż���
	
	d. hibernate��ģ��������״̬�� mybatis�е�ģ��û��״̬֮�֡�
	
2. ������Ϊ��������Ӧ��������������ߣ������ʹ��hibernate���Ͼ�hibernate����Ч�ʼ��ߡ�
			������Ӧ������������ܸߵĻ�����Ӧ��ʹ��mybatis���Ͼ�mybatis�������ٶȸ��죡
			�����Ǵ���߲������⣬�����ǹ���һ��mybatis������ȫ����ġ�����߲�����һ�׼�������
			
			
========================================================================

3. mybatis�����
	a. ��������
		<dependency>
		    <groupId>org.mybatis</groupId>
		    <artifactId>mybatis</artifactId>
		    <version>3.5.2</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.35</version>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
		</dependency>
		<dependency>
		    <groupId>org.projectlombok</groupId>
		    <artifactId>lombok</artifactId>
		    <version>1.18.8</version>
		    <scope>provided</scope>
		</dependency>
		
	b. ���⽨��
		CREATE TABLE USER
		(
		  id INT PRIMARY KEY AUTO_INCREMENT,
		  NAME VARCHAR(20),
		  birthday DATE,
		  money DOUBLE
		);
	c. ����ģ��
		@AllArgsConstructor
		@NoArgsConstructor
		@Data
		public class User implements Serializable {
			private Integer did;
			private String name;
			private Date birthday;
			private Double money;
		}
	d. ����Mybatis�������ļ�
		<?xml version="1.0" encoding="UTF-8" ?>
		<!DOCTYPE mapper
		 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
		 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
		 <!-- 
		 	mapperԪ�ص�namespace���ԣ����Ժ�д������д�ɰ���+�ļ���������xml��׺��
		  -->
		<mapper namespace="com.woniuxy.a_hello.UserMapper">
			<insert id="save" parameterType="com.woniuxy.a_hello.User">
				insert into user values(null,#{name}, #{birthday}, #{money})
			</insert>
		</mapper>
	e. ����Mybatis�������ļ�
		<?xml version="1.0" encoding="UTF-8" ?>
		<!DOCTYPE configuration
		 PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
		 "http://mybatis.org/dtd/mybatis-3-config.dtd">
		<configuration>
			<environments default="development">
				<environment id="development">
					<transactionManager type="JDBC" />
					<dataSource type="POOLED">
						<property name="driver" value="com.mysql.jdbc.Driver" />
						<property name="url" value="jdbc:mysql:///test" />
						<property name="username" value="root" />
						<property name="password" value="123" />
					</dataSource>
				</environment>
			</environments>
			<mappers>
				<mapper resource="com/woniuxy/a_hello/UserMapper.xml" />
			</mappers>
		</configuration>
	f. ���ԣ�
		�ο�AppTest
		
				
		
