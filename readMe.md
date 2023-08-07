
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