#!/usr/bin/env bash
cd /home/ec2-user/server
sudo java -cp . -DenvTarget=prod -Dsome=stuff -jar *.jar > /dev/null 2> /dev/null < /dev/null &