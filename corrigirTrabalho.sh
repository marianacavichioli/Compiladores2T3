#!/bin/bash    

path=$(pwd)
javas="CorretorTrabalho1.jar"
correcaoJar=$path$javas
compiladorJar="java -jar "$path"/Compilador.jar"
pastaTemp=$path"/ArquivosTemporarios/"
casosTeste=$path"/casosDeTesteT1/"




java -jar $javas "\"$compiladorJar\"" gcc $pastaTemp $casosTeste "726556,726580,726568,726586" sintatico 
