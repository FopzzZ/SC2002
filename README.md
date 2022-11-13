## MOBLIMA APP

Created by SC2002 SE3 Group 2
- Pavanraj Selvaraju
- Tan Jin Wei Daniel
- Yan Renyu
- Zheng Rongtao
- Zhou Xuhang

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `javadoc`: the folder to store javadoc
- `bin`: the folder to store compiled output files

## Setup instructions

This project is meant to be opened as a java project in vscode

1) Open project using vscode
2) Run InitialiseDatabase for first time setup
3) Run Main for main program

To run program on command prompt:
1) Add "../" to DataBaseFilePath variable for all applicable controller files (eg in AdminController.java change "database/Admins.txt" to "..\database/Admins.txt")
2) Open command prompt in src folder and compile InitialiseDatabase.java and Main.java using javac
3) Run java InitialiseDatabase in command prompt for first time setup
4) Run java Main to run program