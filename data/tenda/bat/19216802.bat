@echo off

cd .\final\

netsh interface ip set address name="Ethernet 2" static 192.168.0.2 255.255.255.0 192.168.0.1 1