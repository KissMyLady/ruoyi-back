

# 配置文件

tx服务器 nginx配置文件


```sh
user root;
#user  nobody;
worker_processes  1;

#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;
#pid        logs/nginx.pid;

events {
    worker_connections  1024;
}

http {
    include       mime.types;
    default_type  application/octet-stream;

    #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
    #                  '$status $body_bytes_sent "$http_referer" '
    #                  '"$http_user_agent" "$http_x_forwarded_for"';
    #access_log  logs/access.log  main;

    sendfile        on;
    #tcp_nopush     on;
    #keepalive_timeout  0;
    keepalive_timeout  65;
    #gzip  on;
    
    # www.theoracle.top 服务
    server {
        listen      80;
        listen      443 ssl;
        # server_name  localhost;
        server_name  www.theoracle.top;
        charset utf8;

        if ($server_port !~ 443){
            rewrite ^(/.*)$ https://$host$1 permanent;
        }
    	
        ssl_certificate      cert/www/theoracle.top_bundle.pem;
        ssl_certificate_key  cert/www/theoracle.top.key;
        ssl_session_cache    shared:SSL:1m;
        ssl_session_timeout  5m;	
        ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
        ssl_ciphers    ECDHE-RSA-AES128-GCM-SHA256:ECDHE:ECDH:AES:HIGH:!NULL:!aNULL:!MD5:!ADH:!RC4;
        ssl_prefer_server_ciphers  on;

        #access_log  logs/host.access.log  main;

        location / {
            # root   html;
            # index  index.html index.htm;
            root   html;
            index  blog_welcome_index_.html index.htm;
        }

        #error_page  404              /404.html;
        # redirect server error pages to the static page /50x.html
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
	
    # spider.theoracle.top 爬虫App Spider后台服务器
    server {
            listen   80;
            listen   443 ssl;
            # server_name  localhost;
            server_name  spider.theoracle.top;
            charset utf8;
    
        if ($server_port !~ 443){
            rewrite ^(/.*)$ https://$host$1 permanent;
        }

        #access_log  logs/host.access.log  main;
        ssl_certificate      cert/spider/spider.theoracle.top_bundle.pem;
        ssl_certificate_key  cert/spider/spider.theoracle.top.key;
        ssl_session_cache    shared:SSL:1m;
        ssl_session_timeout  5m;	
        ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
        ssl_ciphers    ECDHE-RSA-AES128-GCM-SHA256:ECDHE:ECDH:AES:HIGH:!NULL:!aNULL:!MD5:!ADH:!RC4;
        ssl_prefer_server_ciphers  on;

        # 后端转发到SpringBoot
        location ~* /api/ {
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Real-PORT $remote_port;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_pass http://localhost:9988;
            proxy_redirect default;
        }

        # 静态提供
        location /static {
            expires 30d;
            autoindex on;
            add_header Cache-Control private;
            alias /home/mylady/code/company/gvm_admin_vue/dist/static;
      	}
	
        # 前端
        location / {
            add_header Access-Control-Allow-Origin '*';
            add_header Access-Control-Allow-Credentials: true;
            root   /home/mylady/code/company/gvm_admin_vue/dist;
            index  index.html;
            # root   html;
            # index  index.html index.htm;
            }

        #error_page  404              /404.html;
        # redirect server error pages to the static page /50x.html
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }

    }

    # ruoyi-admin管理后台
    server {
        listen        80;
        listen        443 ssl;
        # server_name   localhost;
        server_name   admin.theoracle.top;
        charset utf8;
        
        if ($server_port !~ 443){
            rewrite ^(/.*)$ https://$host$1 permanent;
        }

        #access_log  logs/host.access.log  main;
	    ssl_certificate      cert/admin/admin.theoracle.top_bundle.pem;
        ssl_certificate_key  cert/admin/admin.theoracle.top.key;
        ssl_session_cache    shared:SSL:1m;
        ssl_session_timeout  5m;	
        ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
        ssl_ciphers    ECDHE-RSA-AES128-GCM-SHA256:ECDHE:ECDH:AES:HIGH:!NULL:!aNULL:!MD5:!ADH:!RC4;
        ssl_prefer_server_ciphers  on;

        location /media {
            expires 30d;
            # autoindex on;
	        add_header Cache-Control private;
            alias /home/mylady/files/web_file/ruoyi_files;
        }

	    location /api/media {
            expires 30d;
            # autoindex on;
	        add_header Cache-Control private;
            alias /home/mylady/files/web_file/ruoyi_files;
        }

        location ~* /api/ {
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Real-PORT $remote_port;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            #开启header的下划线支持:
            proxy_pass http://localhost:8080;
            proxy_redirect default;
        }

        location / {
            root  /home/mylady/code/java/myruoyi/ruoyi-ui/dist;
            try_files $uri $uri/ /index.html;
            index  index.html;
        }

        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }	


}
```