### ע���

1. https://www.cnblogs.com/zeng1994/p/7778145.html
��1������Ҫ��ʹ����sessionFactory.getCurrentSession()��ȡsession�Ĵ������ڵķ������뵽����������У������ȡ����session�ˡ�
��2��sessionFactory.getCurrentSession()��Ҫ��������ģ�����ʵ��session�������ڵĹ����������ǲ�ѯ�������ø�ֻ�������ok��
��Service����ʹ��@Transactionalע�⣬����applicationContext�п���ע������
	<!-- ��������ע�� -->
	<tx:annotation-driven transaction-manager="transactionManager"  />
	�ڿ����У���ס��ʹ����sessionFactory.getCurrentSession()��ȡsessionʱ����Ҫ�����֧�֣�Ҳ����˵��δ������ڵķ���Ҫô�������������У�Ҫô������������ע������
2. web.xml ��Ҫ������WEB-INFĿ¼�¡�
	
	
