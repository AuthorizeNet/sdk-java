@ECHO OFF

@ECHO Starting %DATE%-%TIME%

SET CYGWIN=NODOSFILEWARNING

SET CDIR=%CD%
SET SRCDIR=src\main\java
SET GENFOLDER=net\authorize\api\contract\v1
SET CONTROLLERFOLDER=net\authorize\api\controller

IF NOT EXIST "%SRCDIR%" (
	@ECHO Unable to find "%SRCDIR%"
	EXIT /b 1
)
@ECHO Identifying Requests/Responses to process from "%SRCDIR%"
DIR /s %SRCDIR%\%GENFOLDER%\*.java | grep -i -e "request.java" -e "response.java" > %TEMP%\Sources0.log
DIR /s %SRCDIR%\%CONTROLLERFOLDER%\*Controller.java > %TEMP%\Controllers0.log

@ECHO Cleaning up paths in Sources and Controllers
cut -c40- %TEMP%\Sources0.log      | sort -u | grep -i "\.java" | cut -d. -f1 | sort -u > %TEMP%\Sources1.log
cut -c40- %TEMP%\Controllers0.log  | sort -u | grep -i "\.java" | cut -d. -f1 | sort -u > %TEMP%\Controllers.log

@ECHO Getting Unique Request/Responses
grep -i -e "request *$" -e "response *$" %TEMP%\Sources1.log > %TEMP%\Sources2.log

@ECHO Identifying Object names
perl -pi -w -e 's/Request *$//g;'  %TEMP%\Sources2.log 
perl -pi -w -e 's/Response *$//g;' %TEMP%\Sources2.log  
sort -u %TEMP%\Sources2.log      > %TEMP%\Sources3.log 

@ECHO Fixing Controllers
perl -pi -w -e 's/Controller *$//g;' %TEMP%\Controllers.log

@ECHO Removing ExistingControllers From Request/Response List
@ECHO From File
FOR /F %%X IN (%TEMP%\Controllers.log) DO (
	@ECHO Processing "%%X"
	perl -pi -w -e 's/%%X *$//g;' %TEMP%\Sources3.log  	
)
@ECHO From BlackList
FOR %%X IN (ANetApi AuthenticateTest Error Ids IsAlive Logout XXDoNotUseDummy) DO (
	@ECHO Processing BlackList "%%X"
	perl -pi -w -e 's/%%X *$//g;' %TEMP%\Sources3.log  	
)

@ECHO Creating Final List of Request/Response to generate code
sort -u %TEMP%\Sources3.log   > %TEMP%\Sources.log 

FOR /F %%x IN (%TEMP%\Sources.log ) DO (
	IF EXIST "%SRCDIR%\%CONTROLLERFOLDER%\%%xController.java" (
		@ECHO "%SRCDIR%\%CONTROLLERFOLDER%\%%xController.java" exists, Creating New 
		COPY resources\ControllerTemplate.javat    "%SRCDIR%\%CONTROLLERFOLDER%\%%xController.new"
		perl -pi -w -e 's/APICONTROLLERNAME/%%x/g;' %SRCDIR%\%CONTROLLERFOLDER%\%%xController.new
	) ELSE (
		@ECHO Generating Code for "%SRCDIR%\%CONTROLLERFOLDER%\%%xController.java"
		COPY resources\ControllerTemplate.javat    "%SRCDIR%\%CONTROLLERFOLDER%\%%xController.java"
		perl -pi -w -e 's/APICONTROLLERNAME/%%x/g;' %SRCDIR%\%CONTROLLERFOLDER%\%%xController.java
	)
)
DEL %SRCDIR%\%CONTROLLERFOLDER%\*.bak 1>NUL 2>&1

ENDLOCAL
 	
@ECHO FINISHED %DATE%-%TIME%
