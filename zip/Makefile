clean:
	rm UE3-AG_17_gruppe-9902433-0005273-0304850.zip
	rm UE3-AG_17_gruppe-9902433-0005273-0304850.war
	rm -rf src
	rm -rf "Web Pages"
	rm -rf WEB-INF


zip1:
	cp -r ../src .
	cp -r ../web "./Web Pages"
	cp ../dist/Memory.war ./UE3-AG_17_gruppe-9902433-0005273-0304850.war
	zip -r UE3-AG_17_gruppe-9902433-0005273-0304850 src "Web Pages" *.war

zip2:
	cp -r ../src .
	cp -r ../web "./Web Pages"
	mv "./Web Pages/WEB-INF" .
	cp ../dist/Memory.war ./UE3-AG_17_gruppe-9902433-0005273-0304850.war
	zip -r UE3-AG_17_gruppe-9902433-0005273-0304850 src "./Web Pages" WEB-INF *.war
