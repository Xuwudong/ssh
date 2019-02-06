### ע���
 ʹ����sessionFactory.getCurrentSession()��ȡsessionʱ����Ҫ�����֧�֣�Ҳ����˵��δ������ڵķ���Ҫô�������������У�Ҫô�ڷ�������ʹ��ע�����񡣿ɲο�[����](https://www.cnblogs.com/zeng1994/p/7778145.html)��


   - ����������
   
```
<!-- ֪ͨ -->
	<tx:advice id="txAdvice" transaction-manager="transactionManager">
		<tx:attributes>
			<!-- ������Ϊ -->
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
   - ע��������**Service**����ʹ��**@Transactional**ע�⣬����**applicationContext**�п���ע������

```
<!-- ��������ע�� -->
<tx:annotation-driven transaction-manager="transactionManager"  />
```
```
@Transactional
@Service
public class PersonService {

}
```



2. web.xml��Ҫ������WEB-INFĿ¼�¡�
3. ��������:spring4.3 + hibernate4.3 + mysql8 + tomcat7
4. ��MySQL8.0�У�caching_sha2_password��Ĭ�ϵ������֤�����������mysql_native_password�����Ƕ���mysql�ͻ��˻���֧��caching_sha2_password��֤��ʽ���ӣ�������Խ���Ļ�mysql_native_password����������mysql�������޸��������£�ע����������123456Ϊ�Լ����ݿ����룬�޸ĳɹ�֮��Ϳ��������ˡ�

```
#�޸�root�û������֤��ʽ
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
#ˢ��Ȩ�� 
FLUSH PRIVILEGES;
```

