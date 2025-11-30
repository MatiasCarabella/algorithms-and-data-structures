@echo off
echo Compiling Java project...
echo.

REM Create bin directory if it doesn't exist
if not exist "bin" mkdir bin

REM Compile all Java files
javac -d bin -sourcepath src src/main/java/App.java

if %ERRORLEVEL% EQU 0 (
    echo.
    echo Compilation successful!
    echo.
    echo To run the program, use: run.bat
) else (
    echo.
    echo Compilation failed! Please check the errors above.
)

pause
