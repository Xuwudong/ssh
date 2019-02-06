### 注意点
 使用了sessionFactory.getCurrentSession()获取session时，需要事务的支持；也就是说这段代码所在的方法要么被事务切面切中，要么在方法上面使用注解事务。可参考[链接](https://www.cnblogs.com/zeng1994/p/7778145.html)。


   - 配事务切面
   
```
<!-- 通知 -->
	<tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<!-- 传播行为 -->
			<tx:method name="save*" propagation="REQUIRED"/>
			<tx:method name="delete*" propagation="REQUIRED"/>
			<tx:method name="insert*" propagation="REQUIRED"/>
			<tx:method name="update*" propagation="REQUIRED"/>
			<tx:method name="list*" propagation="SUPPORTS" read-only="true"/>
			<!--<tx:method name="get*" propagation="SUPPORTS" read-only="true"/>  -->
		</tx:attributes>
	</tx:advice>
	<aop:config proxy-target-class="true">
		<aop:advisor advice-ref="txAdvice" pointcut="execution(public * com.xwd.*.service.*Service.*(..))"/>
	</aop:config>
```
   - 注解事务。在**Service**类上使用**@Transactional**注解，并在**applicationContext**中开启注解事务：

```
<!-- 开启事务注解 -->
<tx:annotation-driven transaction-manager="transactionManager"  />
```
```
@Transactional
@Service
public class PersonService {

}
```



2. web.xml需要放置在WEB-INF目录下。
3. 环境配置:spring4.3 + hibernate4.3 + mysql8 + tomcat7
4. 在MySQL8.0中，caching_sha2_password是默认的身份验证插件，而不是mysql_native_password。但是多数mysql客户端还不支持caching_sha2_password认证方式连接，这里可以将其改回mysql_native_password。否则连接mysql将报错。修改命令如下：注意最后的密码123456为自己数据库密码，修改成功之后就可以连接了。

```
#修改root用户插件验证方式
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
#刷新权限 
FLUSH PRIVILEGES;
```

