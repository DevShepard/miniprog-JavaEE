# miniprog-JavaEE
## 微信小程序项目(JAVA后台)
## 开发工具:
           1.inetllij-IDEA-2019.2
           2.微信开发者工具
## 云服务器:
           阿里云ECS轻量级服务器         
## 组件:
           apache-tomcat-8.6.5
           node.js
## 模板:
           Web Application(JAVA后台)
           2.0以下(不使用云开发)
           2.0(使用云开发)
## 版本:
           v1.0 简单的微信小程序访问JAVA后端实现前后台交互
           v1.4 更新微信小程序与mysql以及JAVA交互
           v1.8 更新JAVA后台三层WEB架构
           v2.0 更新微信端与后端交互的云函数
## 注意事项:
           --2.0及以下版本不可实现与云服务器交互,2.0版本可与云服务器交互且测试成功
           --2.0版本已申请SSL证书因此只兼容https协议,未申请SSL证书请自行搭建服务器申请
           --jar包存放于WEB-INF/lib文件夹下
           --现所有版本无法向下兼容(各版本不兼容)
           --v2.0版本云函数使用需要手动加载node.js相关组件,可以手动进行下载(npm install request和npm install wx-server-apk) 
             亦可使用微信云端安装依赖
                   
