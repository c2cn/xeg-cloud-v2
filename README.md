<p align="center">
  <img src="https://www.xiaoergekeji.com/img/logo.0b47a9cd.png" width="260">
</p>
<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-2.3.9.RELEASE-green" alt="SpringBoot"/>
  <img src="https://img.shields.io/badge/Spring%20Cloud-Hoxton.SR10-blue" alt="SpringCloud"/>
  <img src="https://img.shields.io/badge/Spring%20Cloud%20Alibaba-2.2.5.RELEASE-brightgreen" alt="Spring Cloud Alibaba"/>
</p>

xeg-v2是一款基于Spring Cloud Alibaba的微服务架构。为小二哥干活提供服务端支持。

### 官方地址：https://www.xiaoergekeji.com/

### 技术架构
<p align="center"> 
    <img src="https://xiaoerge.oss-cn-beijing.aliyuncs.com/other/xeg-framework.jpg" />
</p>

### 架构特点
- 主体框架：采用最新的Spring Cloud Hoxton SR9, Spring Boot 2.3.10.RELEASE, Spring Cloud Alibaba 2.2.5.RELEASE版本进行系统设计；

- 统一注册：支持Nacos作为注册中心，实现多配置、分群组、分命名空间、多业务模块的注册和发现功能；

- 统一认证：统一Oauth2认证协议，采用jwt的方式，实现统一认证，并支持自定义grant_type实现手机号码登录，第三方登录正在开发中；

- 业务监控：利用Spring Boot Admin 来监控各个独立Service的运行状态；利用Hystrix Dashboard来实时查看接口的运行状态和调用频率等。

- 内部调用：集成了Feign和Dubbo（Develop...）两种模式支持内部调用，并且可以实现无缝切换，适合新老程序员，快速熟悉项目；

- 业务熔断：采用Sentinel实现业务熔断处理，避免服务之间出现雪崩;

- 身份注入：通过注解的方式，实现用户登录信息的快速注入；

- 在线文档：通过接入swagger，实现在线API文档的查看与调试;

- 代码生成：基于Mybatis-plus-generator自动生成代码，提升开发效率，生成模式不断优化中，暂不支持前端代码生成；

- 消息中心：集成消息中间件RocketMQ，对业务进行异步处理;
  
- 链路追踪：自定义traceId的方式，实现简单的链路追踪功能

### 文件结构
```lua
xeg-v2 -- 父项目,各模块分离，方便集成和微服务
│  ├─xeg-admins -- 管理端Controller模块 [15900]
│  ├─xeg-apps -- 移动端Controller主模块
│  │  ├─app-agent -- 代理Controller模块 [15000]
│  │  ├─app-common -- 其他Controller模块 [15100]
│  │  ├─app-employer -- 雇主Controller模块 [15200]
│  │  ├─app-worker -- 工人Controller模块 [15300]
│  │  ├─app-order -- 订单Controller模块 [暂时不用]
│  │  ├─app-user -- 用户Controller模块 [暂时不用]
│  ├─xeg-cores -- 核心通用模块，主模块
│  │  ├─core-base -- 封装通用模块
│  │  ├─core-elasticsearch -- 封装ElasticSearch模块
│  │  ├─core-mongodb -- 封装mongodb数据库模块
│  │  ├─core-mysql -- 封装mysql数据库模块
│  │  ├─core-redis -- 封装redis缓存模块
│  │  ├─core-server -- 封装微服务模块
│  │  ├─core-swagger -- 封装Swagger在线Api文档模块
│  │  ├─core-topic -- 封装消息发布-订阅基础模块
│  │─xeg-devops-gateway -- 统一网关模块 [13000]
│  │─xeg-devops-scheduler -- 统一任务调度模块
│  ├─xeg-servers -- 服务实现模块，主模块
│  │  ├─server-agent -- 代理服务Impl模块 [16100]
│  │  ├─server-base -- 基础服务Impl模块 [16000] 
│  │  ├─server-chat -- 聊天室服务Impl模块 [16200]
│  │  ├─server-live -- 直播间服务Impl模块 [16300]
│  │  ├─server-order -- 订单服务Impl模块 [16400]
│  │  ├─server-pay -- 支付服务Impl模块 [16500]
│  │  ├─server-push -- 推送服务Impl模块 [16600]
│  │  ├─server-search -- 搜索服务Impl模块 [16700]
│  │  ├─server-task -- 任务调度服务Impl模块 [16800]
│  │  ├─server-user -- 用户服务Impl模块 [16900]
│  ├─xeg-servers-apis -- 服务API模块，主模块 
│  │  ├─server-agent-api -- 代理服务API模块
│  │  ├─server-base-api -- 基础服务API模块 
│  │  ├─server-chat-api -- 聊天室服务API模块
│  │  ├─server-live-api -- 直播间服务API模块
│  │  ├─server-order-api -- 订单服务API模块
│  │  ├─server-pay-api -- 支付服务API模块
│  │  ├─server-push-api -- 推送服务API模块
│  │  ├─server-search-api -- 搜索服务API模块
│  │  ├─server-task-api -- 任务调度服务API模块
│  │  ├─server-user-api -- 用户服务API模块
 
```
## 项目源码
|  项目   |   GITEA  |
|---  |--- |
|  xeg-v2源码   |  http://gitea.xiaodandanlaowu.com/java/xeg-v2.git   |

## 特别鸣谢
特别感谢宁神对xeg-v2项目提供的技术支持！
