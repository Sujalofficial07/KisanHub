@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  Gradle startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

@rem Resolve any "." and ".." in APP_HOME to get the absolute path
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem For Cygwin, ensure paths are in UNIX format before anything is touched
if not "%OS%"=="Windows_NT" goto skipCygwin
if exist "%SystemRoot%\System32\cygpath.exe" (
    for /f "usebackq" %%i in (`%SystemRoot%\System32\cygpath.exe -u "%APP_HOME%"`) do set APP_HOME=%%i
    for /f "usebackq" %%i in (`%SystemRoot%\System32\cygpath.exe -u "%JAVA_HOME%"`) do set JAVA_HOME=%%i
)
:skipCygwin

@rem Locate a Java executable
if defined JAVA_HOME (
    if exist "%JAVA_HOME%\bin\java.exe" (
        set "JAVACMD=%JAVA_HOME%\bin\java.exe"
    )
)

if not defined JAVACMD (
    set JAVACMD=java.exe
)

"%JAVACMD%" -version >nul 2>&1
if %ERRORLEVEL% neq 0 (
    echo Error: JAVA_HOME is not defined correctly.
    echo We cannot execute %JAVACMD%
    goto end
)

@rem Set standard commands for invoking Java.
set CLASSPATH=%APP_HOME%\gradle\wrapper\gradle-wrapper.jar

@rem Execute Gradle
"%JAVACMD%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% "-Dorg.gradle.appname=%APP_BASE_NAME%" -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*

:end
if "%OS%"=="Windows_NT" endlocal
