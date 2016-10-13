# matrix-template

该工程是`Matrix`项目Java组开发Web业务的模板工程，后续业务开发时请使用该工程作为基础模板。使用时请修改相应配置为所属业务配置，并做相应的裁剪。

## 工程介绍
* 提供Dubbox服务，支持REST风格远程调用（HTTP + JSON/XML)，支持基于Kryo和FST的Java高效序列化实现，支持基于Jackson的JSON序列化，支持基于嵌入式Tomcat的HTTP remoting体系；
* 提供SpringMVC，有完整的Web UI系统和Web API系统相应数据返回、异常统一捕获、拦截器等功能；
* 提供`Disconf`动态配置功能。

## 使用注意事项
* 建议以后所有业务代码使用该工程，由该工程统一维护业务工程基础依赖，对于特殊依赖，由具体业务完成；
* 注意查看[changelog](CHANGELOG.md)，浏览`matrix-template`工程每个版本变化。

## 版本更新说明

请查看[changelog](CHANGELOG.md)
