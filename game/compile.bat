@echo off
cd /d "%~dp0"
mkdir target\classes 2>nul
javac -d target\classes -cp src\main\java src\main\java\com\example\*.java src\main\java\com\example\client\*.java src\main\java\com\example\common\*.java src\main\java\com\example\server\*.java
if %errorlevel% equ 0 (
    echo 編譯成功！
    dir target\classes /s
) else (
    echo 編譯失敗！
)
pause
