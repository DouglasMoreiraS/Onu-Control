@echo off
title TendaBatchPresetUpgrade

if not exist RouterCfm_Batch.cfg echo RouterCfm_Batch.cfg is nonexist
if not exist RouterCfm_Batch.cfg pause
if not exist RouterCfm_Batch.cfg exit

cd .\PresetUpgradeTools\
del ????????????.bin
del RouterCfm_????????????.cfg

move ..\RouterCfm_Batch.cfg .

start RunStandAlone.bat
echo Wscript.sleep 2000 >y.vbs
call y.vbs &del y.vbs
start RunStandAloneMT.bat

