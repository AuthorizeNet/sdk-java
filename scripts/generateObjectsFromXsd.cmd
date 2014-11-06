@ECHO OFF

CALL "%~dp0\validateCygwinBinaries.cmd"
IF "1"=="%ERRORLEVEL%" (
    @ECHO Invalid or incomplete Cygwin installation. Install cygwin and its components viz.
    @ECHO grep sed perl cut touch wget sort
    EXIT /b 1
)
SET CYGWIN_EXE=%CYGWIN_HOME%\bin

where xjc.exe > NUL 2>&1
IF "1"=="%ERRORLEVEL%" (
    @ECHO Unable to find xjc.exe in the path. Locate it and add it directory to the path
    @ECHO Usually it is found under JDK bin viz. "C:\custom\Java180_05\bin\xjc.exe"
    EXIT /b 1
)

SETLOCAL
@ECHO Starting %DATE%-%TIME%


SET LOCALXSD=%TEMP%\AnetApiSchema.xsd
SET LOCALWSDL=%TEMP%\AnetApiSchema.wsdl
SET selection=N
CHOICE /C YN  /T 10 /D N /M "Fetch and update Schema/WSDL file from remote server?"
IF "%ERRORLEVEL%"=="1" (
    @ECHO Fetching Schema/WSDL files 
    SET %ERRORLEVEL%=
    CALL "%~dp0\getXsdWsdl.cmd" %LOCALXSD% %LOCALWSDL%
    SET ERRORCODE=%ERRORLEVEL%
    @ECHO GetXsdWsdl Call Exit Code:%ERRORCODE%
    IF NOT "%ERRORLEVEL%"=="0" (
       @ECHO Error fetching source files
       @ECHO ##### ***** $$$$$ CHECK FOR ERROR $$$$$ ***** #####
       REM EXIT /b 1
    )
) ELSE (
    @ECHO Schema/WSDL files have not been updated!
)
SET XSDSRCDIR=src/main/java/
SET XSDPACKAGE=net.authorize.api.contract.v1
SET XSDGENFOLDER=%XSDPACKAGE:.=/%

SET WSDLSRCDIR=src/wsdlgen/java/
SET WSDLPACKAGE=net.authorize.api.contract.v1

IF NOT EXIST "%LOCALXSD%" (
    @ECHO Unable to find "%LOCALXSD%"
    EXIT /b 1
)
IF NOT EXIST "%LOCALWSDL%" (
    @ECHO Unable to find "%LOCALWSDL%"
    @REM EXIT /b 1
)
@ECHO Validating target folder "%XSDSRCDIR%"
IF NOT EXIST %XSDSRCDIR% (
        MD "%XSDSRCDIR%"
)
@ECHO Validating target folder "%WSDLSRCDIR%"
IF NOT EXIST %WSDLSRCDIR% (
        MD "%WSDLSRCDIR%"
)

@ECHO Generating sources from Schema: %XSD% in folder "%XSDSRCDIR%"
@ECHO: Command Line: xjc -verbose -d "%XSDSRCDIR%"  -p "%XSDPACKAGE%" "%LOCALXSD%"
xjc            -verbose -d "%XSDSRCDIR%"  -p "%XSDPACKAGE%"              "%LOCALXSD%"

@ECHO **NOT** Generating source from WSDL: %WSDL% in folder "%WSDLSRCDIR%"
REM wsimport -keep -verbose -d "%WSDLSRCDIR%" -p "%WSDLPACKAGE%" -Xnocompile "%LOCALWSDL%"

@ECHO Adding Serializable to the Base Request/Response
FOR %%x IN (Request Response) DO (
    @ECHO Processing "%%x" in file %XSDSRCDIR%%XSDGENFOLDER%\ANetApi%%x.java
    IF EXIST "%XSDSRCDIR%%XSDGENFOLDER%\ANetApi%%x.java" (
        REM DIR /s/b "%XSDSRCDIR%%XSDGENFOLDER%\ANetApi%%x.java" 
        REM FINDSTR /i /s /c:"public class" "ANetApi%%x.java" 
        "%CYGWIN_EXE%\perl.exe" -pi -w -e 's/public class ANetApi%%x */public class ANetApi%%x implements java.io.Serializable /g;'  %XSDSRCDIR%%XSDGENFOLDER%/ANetApi%%x.java
        FINDSTR /i /s /c:"public class" "ANetApi%%x.java" 
    ) ELSE (
        @ECHO File "%XSDSRCDIR%%XSDGENFOLDER%\ANetApi%%x.java"  Does not exist
    )
)
DEL /q /s *.bak
ENDLOCAL
@ECHO FINISHED %DATE%-%TIME%
