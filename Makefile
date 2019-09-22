#!/bin/bash
#
# Makefile
# 
# Purpose: Compile Zelda game package and run it. 
# 
# Site: http://www.dirackslounge.online
# 
# Version 1.0
# 
# Programer: Rodolfo A. C. Neves (Dirack) 19/09/2019
# 
# Email (Manutenção): rodolfo_profissional@hotmail.com
# 
# License: GPL-3.0 <https://www.gnu.org/licenses/gpl-3.0.txt>.

CC = javac
PAC = $(wildcard ./Zelda/*.java)
DEP = $(PAC:.java=.class)
MAIN = Main.java
MAINCLASS = $(MAIN:.java=.class)
BIN = $(MAIN:.java=)
RES = $(wildcard ./images/*)
JARFILE = zelda.jar

all:	libbed run

libbed:	$(DEP)

run:	$(MAINCLASS)
	nice -19 java $(BIN)

%.class:	%.java
	$(CC) $<

clean:
	rm $(DEP)
	rm *.class

jar:	$(JARFILE)

$(JARFILE):	$(DEP) $(RES)
	jar cmvf MANIFEST.MF $@ $(MAINCLASS) $(DEP) $(RES)

runjar:	$(JARFILE)
	java -jar $(JARFILE)
