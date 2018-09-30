#!/bin/bash

APP=wechat

docker stop $APP
docker rm $APP
docker pull qinlikang/$APP
docker run -d -p 80:8080 --name $APP qinlikang/$APP

