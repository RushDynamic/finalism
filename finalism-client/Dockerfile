FROM node:14 as builder
WORKDIR /app
COPY ["package.json", "package-lock.json", "./"]
RUN npm install
COPY . .
RUN npm run build

FROM nginx:alpine
RUN apk add --no-cache bash
RUN ln -sf /dev/stdout /var/log/nginx/access.log \
    && ln -sf /dev/stderr /var/log/nginx/error.log
WORKDIR /var/www/finalism/html
RUN rm -rf ./*
COPY --from=builder /app/build/ .
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx.conf /etc/nginx/conf.d
# certbot config
#certbot certonly --webroot --webroot-path=/var/www/html --email hello@climguards.com --agree-tos --no-eff-email --staging -d climguards.com -d www.climguards.com

RUN sudo apt install certbot python3-certbot-nginx
RUN sudo certbot certonly --webroot --webroot-path=/var/www/finalism/html --email rushdynamic1ms@gmail.com --agree-tos --no-eff-email -d flsm.rushdynamic.com
EXPOSE 80 443
ENTRYPOINT ["nginx", "-g", "daemon off;"]