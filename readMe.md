
> 项目结构 dao层 api层

> 什么是自定义注解？

三个元注解 加 默认值
Person.class.getDeclaredFields()
可以获取到类上面的注解
自定义注解的作用是啥 有什么好处 用在哪？

可以放在类上面 通过反射来获取注解上的属性值
还可以在aop中拦截controller 然后其中的方法getMethod以及方法的getDeclaredAnnotation

elasticsearch 
如果有id 再次插入数据会覆盖 如果没有id会生成新的数据

Apollo配置实时读取 目前读取配置通过设置JVM参数 -Dapollo.configService=http://172.16.244.134:8081 -Denv=DEV
读取单值  读取list  1001,1002,1003  读取list对象 [{"name":"xx"},{}] SingleSwitch 读取对象

> 读取list对象
JSON.parseArray(params, SingleSwitch.class)

> 读取对象
JSON.parseObject(param, Addr.class)


事务失效的几个场景  @Transactional注解
1、异常捕获后未抛出
2、抛出了非运行时异常 throw new MyException
3、方法内部直接调用  一个方法调用了同一个类中的事务方法 因为没有生成代理，修改方式可以把当前类自己注入一下调用即可
4、新开启了一个线程 且线程内有异常
  因为springboot实现事务的原理是通过ThreadLocal把数据库连接绑定到当前线程中 新开启一个线程取到的连接就不是同一个了
5、注解到private方法上
6、数据库本身不支持  比如必须是数据库引擎 innoDB
7、事务传播属性设置错误 （以非事务的方式执行，如果当前有事务则把当前事务挂起）

Spring 事务传播机制 7种
1、Propagation.REQUIRED 如果当前存在事务 则加入该事务 如果当前没有事务 则创建一个新的事务 （默认的事务传播级别）
2、Propagation.SUPPORTS 如果当前存在事务 则加入该事务 如果当前没有事务 则以非事务的方式继续运行

> Spring Boot启动的时候会通过@EnableAutoConfiguration注解找到META-INF/spring.factories配置文件中的所有自动配置类，并对其进行加载，
> 而这些自动配置类都是以AutoConfiguration结尾来命名的，它实际上就是一个JavaConfig形式的Spring容器配置类，
> 它能通过以Properties结尾命名的类中取得在全局配置文件中配置的属性如：server.port，而XxxxProperties类是通过@ConfigurationProperties注解与全局配置文件中对应的属性进行绑定的。
   示例： https://zhuanlan.zhihu.com/p/399405329

