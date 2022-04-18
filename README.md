# netty-im
基于netty搭建的tcp通信服务

基于Ubuntu20使用OpenSSL服务，运行以下命令:
```
sudo vim /etc/apt/sources.list
#向文件中添加一行
deb http://security.ubuntu.com/ubuntu xenial-security main

#运行命令
sudo apt update
sudo apt install libssl1.0.0
sudo apt install libapr1
```
使用以下命令将下载tomcat版本证书的pfx转为key文件：
```
openssl pkcs12 -in 5375262_im.shawnhe.tech.pfx -nocerts -nodes -out server.key
```
直接使用nginx版本证书的pem文件
