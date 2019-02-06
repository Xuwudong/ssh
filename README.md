### 注意点

1. https://www.cnblogs.com/zeng1994/p/7778145.html
（1）必须要将使用了sessionFactory.getCurrentSession()获取session的代码所在的方法加入到事务管理器中；否则获取不到session了。
（2）sessionFactory.getCurrentSession()是要基于事务的，才能实现session生命周期的管理。所以我们查询方法上用个只读事务就ok了
在Service类上使用@Transactional注解，并在applicationContext中开启注解事务：
	<!-- 开启事务注解 -->
	<tx:annotation-driven transaction-manager="transactionManager"  />
	在开发中，记住：使用了sessionFactory.getCurrentSession()获取session时，需要事务的支持；也就是说这段代码所在的方法要么被事务切面切中，要么方法上面用了注解事务。
2. web.xml 需要放置在WEB-INF目录下。
	
	
