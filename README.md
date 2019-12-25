使用说明：
   1.管理手机app各种不同版本之间方法的调用，简化较少不必要的代码，以及为部署不同版本的服务器；
   2.提供控制层还有service层的不同的不同版本的方法；
   3.提供方法执行前，后，环绕执行的自定义方法；
   
   
注解说明：Code表示接口的编号，不同版本中的相同方法，应该遵循的是code一致；不同方法的code禁止相同（TODO 对应校验还未做）
           	特别说明，由于此项目是自己在 天天拍车 公司的一个盘库项目中写的，该公司的规定是所有后台接口统一走一个控制层接口
           	再有接口的code 值，进行分发调用不同的接口；TODO 所以这个普适性太低，后期会用spring原生的控制层路径注解制层接口径；
 	   Igonre 表示不需要版本控制的方法，只要标记该注解，启动时候，该类的信息就不会被加载进内存；
       MethodVersion 表示当前方法能够兼容哪些版本的服务，eg: "1.0.1,1.0.2" 表示当前方法支持1.0.1,1.0.2版本的功能
       Version 标签类的版本号，当前类的版本号，和MethodVersion版本号中关系是，当前类的任意一个MethodVersion的最小版本信息
                                       必须是当前version版本一致；（TODO 该校验后期会加上去）
                                      正例eg:Version("1.0.1") MethodVersion({"1.0.1","1.0.2"})
                                      反例eg:Version("1.0.1") MethodVersion({"1.0.0","1.0.1"})
	   Before  版本控制方法的前置执行方法； 
	   After   版本控制方法的后置执行方法； 
	   Around  版本控制方法的环绕执行方法；
	        使用方式 demo:实现 InterceptorHandler 在自定义方法上 Before("learn.test.impl") 目前这些方法的执行的粒度只是最粗粒度，到了包级别
	        TODO 后期会粒度会到类级别， 方法级别；
	      
开发说明：1.初始化的类是VersionHandler 类实现的InitializingBean 接口的重写的 afterPropertiesSet 方法是程序的入口
                       由于实现的是spring的接口，无形中和spring耦合了，后期会想办法将该项目的初始化方式和一切其他框架解耦；增加工具通用性
       2.代码的最初始化版本功能已经是能够实现；  Before,After,Around方法的功能暂未实现；（截止2019.09.26）
       3.             
	   



      
	    
	         