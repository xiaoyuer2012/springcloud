#### springcloud-test 为框架搭建前准备源码，为集成eureka做准备 
#### springcloud-test-eureka 集成服务注册与发现组件 eureka
#### springcloud-test-eureka-feign 集成eureka与feign

#### 遇到问题
#### 将Feign封装到单独的模块，包名一定要和客户端的包名一致，否则运行时找不到对应的Feign类
#### 模块目录调整，导致运行时编译路径不对的问题，可以重新建一下maven模块，可解决此问题。或者修改下*.imp文件中的output 值
#### Feign模块间调用，是不通过zuul的。
