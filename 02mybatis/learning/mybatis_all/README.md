免责声明：
- mybatis_all 代码来自书籍《深入浅出MyBatis技术原理与实战》

## 导入项目
直接用idea打开
## 导入数据
执行02mybatis/db/mybatis.sql的sql

## 项目介绍
### chapter2
chapter2 mybatis的入门

#### 2.1 mybatis入门

##### 2.2 mybatis的基本构成
###### 2.2.1 构建SqlSessionFactory:
根据配置信息或者代码生成SqlSessionFactory，构建方式有xml配置或者java代码编写
###### 2.2.2 创建SqlSession
SqlSession：sql会话，执行sql的方式有2种，一种是执行satament（案例在Chapter2Main02）,另外一种是获取Mapper,然后让mapper去执行sql（案例在Chapter2Main01）
###### 2.2.3 映射器
Mapper:映射器，mapper负责发送sql去执行，生成的方式也有2种：xml配置和java编码，如果去执行sql的，关联的方式也有2种：xml配置和注解（RoleMapping1.java)

- [ ] 基本构成的关系图

##### 2.3 生命周期
##### 2.4 实例

### chapter3 配置

- [ ] chapter3 配置

### chapter6 Mybatis
#### 6.1 技术难点介绍
##### 6.1.1 反射技术
##### 6.1.2 jdk动态代理
缺陷：需要定义接口
##### 6.1.3 CGLB动态代理

### 6.2 构建SqlSessionFactory过程
构建步骤分2步：
1. 解析配置文件，将配置信息存储在Configuraction类中
2. 使用Configuarction去创建SqlSessionFactory

##### 6.3 SqlSession运行过程
###### 6.3.1 映射器的动态代理
使用动态代理对象，最后能调用SqlSesssion对象执行sql
###### 6.3.2 SqlSession下的四大对象
Executor:执行器，存在三种执行器
StataementHandler:
ParameterHander:
ResultHandler:对结果集合的封装


### chapter7 插件
#### 7.1 插件接口

- [x] 上述代码经过本人测试，是可用的














