process=`ps -ef | grep spring-boot:run | grep "mspringboot"`
pid=`echo $process | cut -d ' ' -f 2`
echo pid = $pid

if  [ ! -n "$pid" ] ;then
    echo "mspringboot未启动，不用kill"
else
    kill -9 $pid
    echo "kill mspringboot"
fi


nohup mvn spring-boot:run &




