@echo off
setlocal

set MODULE_PATH=%USERPROFILE%\.m2\repository\org\openjfx\javafx-controls\21.0.3\javafx-controls-21.0.3-win.jar;%USERPROFILE%\.m2\repository\org\openjfx\javafx-graphics\21.0.3\javafx-graphics-21.0.3-win.jar;%USERPROFILE%\.m2\repository\org\openjfx\javafx-base\21.0.3\javafx-base-21.0.3-win.jar;%USERPROFILE%\.m2\repository\org\openjfx\javafx-fxml\21.0.3\javafx-fxml-21.0.3-win.jar

java --module-path "%MODULE_PATH%" --add-modules javafx.controls,javafx.fxml -cp target\classes com.cvbuilder.Main

pause


