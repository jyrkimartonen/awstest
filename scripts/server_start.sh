#!/usr/bin/env bash
cd /home/ec2-user/server
sudo java -DenvTarget=prod -Dsome=stuff -Dserver.port=80 -jar *.jar > /dev/null 2> /dev/null < /dev/null &