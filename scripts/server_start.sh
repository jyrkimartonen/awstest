#!/usr/bin/env bash
cd /home/ec2-user/server
sudo java -jar -DenvTarget=prod -Dsome=stuff *.jar > /dev/null 2> /dev/null < /dev/null &