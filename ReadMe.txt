Instructions to build & install JUnit Kata application
------------------------------------------------------

1. Open Browser, Go to https://github.com/rrao5/demo

2. Click on "Clone to Desktop" --> This clones the source code to <user_home>\Documents\GitHub; creates a folder "demo"

3. Download & Install Lombok.jar
a. Download Lombok jar from http://projectlombok.org/download.html
b. Double Click on the jar, enter the location information of IDE (eclispe). This updates the eclipse.ini. Please verify that the following lines have been added to eclipse.ini file. If not, you can manually update it.
-javaagent:lombok.jar
-Xbootclasspath/a:lombok.jar
c. Add the following arguments to the eclipse startup script or command line, for e.g.:
<path_toSTS>\STS.exe -vmargs -Xbootclasspath/a:lombok.jar -javaagent:lombok.jar

4. Restart eclipse (or STS)

5. Select the workspace as GitHub directory

6. Click on "Import-->Existing Maven Projects"; Pick root directory as <pathtoGithubFolder>\GitHub\demo; This will display the pom.xml file.

7. Click "FINISH"

8. When the project is loaded; 
a. Right CLick on Project(demo);
b. Click on "Run As --> Maven Clean"
c. Click on "Run As --> Maven Install"
d. If you see any compilation errors, click on "Project-->clean"
e. Repeat steps "b" and "c"

