怎么使用
1.修改user-service-core和-user中的数据库连接用户账户密码
2.启动provider(user-service-user),启动consumer(user-service-core),启动web查看效果
  


节点类型(Persistent) : 客户端和服务器端断开连接后,创建的节点不删除
短暂(Ephemeral) : 客户端和服务器端断开连接后,创建的节点自己删除

在分布式系统中,顺序号可以被用于为所有的事件进行全局排序,这样客户端可以通过
顺序号推断事件的顺序




