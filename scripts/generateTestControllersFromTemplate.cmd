@ECHO OFF

CALL "%~dp0\validateCygwinBinaries.cmd"
IF "1"=="%ERRORLEVEL%" (
    @ECHO Invalid or incomplete Cygwin installation. Install cygwin and its components viz.
    @ECHO grep sed perl cut touch wget sort
    EXIT /b 1
)
SET CYGWIN_EXE=%CYGWIN_HOME%\bin

@ECHO Starting %DATE%-%TIME%

SET CYGWIN=NODOSFILEWARNING

SET CDIR=%CD%
SET SRCDIR=src\main\java
SET GENFOLDER=net\authorize\api\contract\v1
SET TESTDIR=src\test\java
SET CONTROLLERFOLDER=net\authorize\api\controller\mocktest

SET SRCLOG=%CD%\log\TestSources
SET CNTLOG=%CD%\log\TestControllers
IF EXIST "%CD%\log" (
    DEL /q/s "%CD%\log\*.*" > NUL
) ELSE (
    MD "%CD%\log\"
)

IF NOT EXIST "%SRCDIR%" (
    @ECHO Unable to find "%SRCDIR%"
    EXIT /b 1
)
@ECHO Identifying Requests/Responses to process from "%SRCDIR%"
DIR /s %SRCDIR%\%GENFOLDER%\*.java | "%CYGWIN_EXE%\grep.exe" -i -e "request\.java" -e "response\.java" > %SRCLOG%0.log
DIR /s %TESTDIR%\%CONTROLLERFOLDER%\*ControllerTest.java > %CNTLOG%0.log

@ECHO Cleaning up paths in Sources and Controllers
"%CYGWIN_EXE%\cut.exe" -c40- %SRCLOG%0.log  | "%CYGWIN_EXE%\sort.exe" -u | "%CYGWIN_EXE%\grep.exe" -i "\.java" | "%CYGWIN_EXE%\cut.exe" -d. -f1 | "%CYGWIN_EXE%\sort.exe" -u > %SRCLOG%1.log
"%CYGWIN_EXE%\cut.exe" -c40- %CNTLOG%0.log  | "%CYGWIN_EXE%\sort.exe" -u | "%CYGWIN_EXE%\grep.exe" -i "\.java" | "%CYGWIN_EXE%\cut.exe" -d. -f1 | "%CYGWIN_EXE%\sort.exe" -u > %CNTLOG%.log

@ECHO Getting Unique Request/Responses
"%CYGWIN_EXE%\grep.exe" -i -e "request *$" -e "response *$" %SRCLOG%1.log > %SRCLOG%2.log

@ECHO Identifying Object names
"%CYGWIN_EXE%\perl.exe" -pi -w -e 's/Request *$//g;'  %SRCLOG%2.log
"%CYGWIN_EXE%\perl.exe" -pi -w -e 's/Response *$//g;' %SRCLOG%2.log
"%CYGWIN_EXE%\sort.exe" -u %SRCLOG%2.log      > %SRCLOG%3.log

@ECHO Fixing Controllers
"%CYGWIN_EXE%\perl.exe" -pi -w -e 's/ControllerTest *$//g;' %CNTLOG%.log
@REM Create backup for later comparison
COPY %SRCLOG%3.log %SRCLOG%4.log >NUL
COPY %CNTLOG%.log  %CNTLOG%9.log >NUL

@ECHO Removing ExistingControllers From Request/Response List
@ECHO From File
FOR /F %%X IN (%CNTLOG%.log) DO (
    @ECHO Processing "%%X"
    "%CYGWIN_EXE%\perl.exe" -pi -w -e 's/^\b%%X\b *$//g;' %SRCLOG%3.log      
)

@ECHO From BlackList
FOR %%X IN (ANetApi Error Ids XXDoNotUseDummy) DO (
    @ECHO Processing BlackList "%%X"
    "%CYGWIN_EXE%\perl.exe" -pi -w -e 's/^\b%%X\b *$//g;' %SRCLOG%3.log
)

@ECHO Creating Final List of Request/Response to generate code
"%CYGWIN_EXE%\sort.exe" -u %SRCLOG%3.log   > %SRCLOG%.log

FOR /F %%x IN (%SRCLOG%.log ) DO (
    IF EXIST "%TESTDIR%\%CONTROLLERFOLDER%\%%xControllerTest.java" (
        @ECHO "%TESTDIR%\%CONTROLLERFOLDER%\%%xControllerTest.java" exists, Creating New
        COPY resources\ControllerTemplateTest.javat    "%TESTDIR%\%CONTROLLERFOLDER%\%%xControllerTest.new"
        "%CYGWIN_EXE%\perl.exe" -pi -w -e 's/APICONTROLLERNAME/%%x/g;'     %TESTDIR%\%CONTROLLERFOLDER%\%%xControllerTest.new
    ) ELSE (
        @ECHO Generating Code for "%TESTDIR%\%CONTROLLERFOLDER%\%%xControllerTest.java"
        COPY resources\ControllerTemplateTest.javat    "%TESTDIR%\%CONTROLLERFOLDER%\%%xControllerTest.java"
        "%CYGWIN_EXE%\perl.exe" -pi -w -e 's/APICONTROLLERNAME/%%x/g;'     %TESTDIR%\%CONTROLLERFOLDER%\%%xControllerTest.java
    )
)
@REM Identify Obsolete Controllers
@ECHO From Request/ResponseList
FOR /F %%X IN (%SRCLOG%4.log) DO (
    @ECHO Processing "%%X"
    "%CYGWIN_EXE%\perl.exe" -pi -w -e 's/%%X *$//g;' %CNTLOG%9.log      
)
@ECHO Following are Obsolete Controllers
"%CYGWIN_EXE%\sort.exe" -u %CNTLOG%9.log      
DEL /s *.bak 1>NUL 2>&1

ENDLOCAL
     
@ECHO FINISHED %DATE%-%TIME%
