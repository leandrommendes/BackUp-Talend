%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=%cd%/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp .;../lib/routines.jar;../lib/ant-1.10.1.jar;../lib/checkArchive-1.1-20171121.jar;../lib/commons-compress-1.10.jar;../lib/dom4j-1.6.1.jar;../lib/log4j-1.2.17.jar;../lib/talendzip.jar;../lib/zip4j_1.3.1.jar;testefile_0_1.jar; local_project.testefile_0_1.testefile  %*