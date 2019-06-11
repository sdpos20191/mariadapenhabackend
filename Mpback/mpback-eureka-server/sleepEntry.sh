#!/bin/sh

webserv=$1
keyword=$2
stat="error"

available () {
        echo "Testing availability"
        if curl -s "$webserv" | grep "$keyword"
        then
            # if the keyword is in the conent
            echo $webserv "is working fine"
            stat="ok"
        else
            echo $webserv "still not up"
        fi
}

echo Aguardando $webserv;

available

while [ $stat != "ok" ]; do

        sleep 1
        available

done

echo Iniciando ...
                             
java -jar $3