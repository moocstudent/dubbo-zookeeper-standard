user-service-core UserController 路径写好
<br>
user-service-user UserBll 类似dao层写好
<br>
UserMapper 接口写好
<br>
mapper中UserMapper.xml写好
<br>
加入了index.html 实现获取用户,新增更改删除操作

搭建了dubbo-admin 和 zookeeper在linux上http://60.205.224.226/ root root

##### 2019-12-13
1.dubbo-zookeeper的该项目如何部署?
2.文件上传 存放位置
3.集群形式的更改

服务动态上下线?
zookeeper的软负载均衡?


节点类型(Persistent) : 客户端和服务器端断开连接后,创建的节点不删除
短暂(Ephemeral) : 客户端和服务器端断开连接后,创建的节点自己删除

在分布式系统中,顺序号可以被用于为所有的事件进行全局排序,这样客户端可以通过
顺序号推断事件的顺序




