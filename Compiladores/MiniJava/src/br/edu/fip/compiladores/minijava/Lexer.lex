package br.edu.fip.compiladores.minijava;

import java_cup.runtime.*;

%%

%{
private void imprimir(String descricao, String lexema) {
    System.out.println(lexema + "\t- " + descricao);
}
%}

%cup
%public
%class AnalisadorLexico
%type java_cup.runtime.Symbol
%line
%column
%char

BRANCO = [ |\n|\t|\r|\f]
ID = [a-z|A-Z][a-z|A-Z|0-9|_]*
NUM = 0|[1-9][0-9]*

%%

"boolean"                   { return new Symbol(sym.BOOLEAN); }
"class"                     { return new Symbol(sym.CLASS); }
"extends"                   { return new Symbol(sym.EXTENDS); }
"public"                    { return new Symbol(sym.PUBLIC); }
"static"                    { return new Symbol(sym.STATIC); }
"void"                      { return new Symbol(sym.VOID); }
"main"                      { return new Symbol(sym.MAIN); }
"String"                    { return new Symbol(sym.STRING); }
"return"                    { return new Symbol(sym.RETURN); }
"int"                       { return new Symbol(sym.INT); }
"if"                        { return new Symbol(sym.IF); }
"else"                      { return new Symbol(sym.ELSE); }
"while"                     { return new Symbol(sym.WHILE); }
"System.out.println"        { return new Symbol(sym.SYSTEM_OUT_PRINTLN); }
"length"                    { return new Symbol(sym.LENGTH); }
"true"                      { return new Symbol(sym.TRUE); }
"false"                     { return new Symbol(sym.FALSE); }
"this"                      { return new Symbol(sym.THIS); }
"new"                       { return new Symbol(sym.NEW); }

{BRANCO}                    { }
{ID}                        { return new Symbol(sym.ID); }
{NUM}                       { return new Symbol(sym.NUM); }

"{"                         { return new Symbol(sym.CHAVE_ESQUERDA); }
"}"                         { return new Symbol(sym.CHAVE_DIREITA); }
"["                         { return new Symbol(sym.COLCHETE_ESQUERDA); }
"]"                         { return new Symbol(sym.COLCHETE_DIREITA); }
"("                         { return new Symbol(sym.PARENTESES_ESQUERDA); }
")"                         { return new Symbol(sym.PARENTESES_DIREITA); }
";"                         { return new Symbol(sym.PONTO_E_VIRGULA); }
"."                         { return new Symbol(sym.PONTO); }
","                         { return new Symbol(sym.VIRGULA); }
"="                         { return new Symbol(sym.IGUAL); }
"<"                         { return new Symbol(sym.MENOR_QUE); }
"=="                        { return new Symbol(sym.IGUAL_IGUAL); }
"!="                        { return new Symbol(sym.EXCLAMACAO_IGUAL); }
"+"                         { return new Symbol(sym.ADICAO); }
"-"                         { return new Symbol(sym.SUBTRACAO); }
"*"                         { return new Symbol(sym.MULTIPLICACAO); }
"/"                         { return new Symbol(sym.DIVISAO); }
"&&"                        { return new Symbol(sym.AND); }
"!"                         { return new Symbol(sym.EXCLAMACAO); }

. { throw new RuntimeException("Caractere invalido \"" +yytext() +
"\" na linha "+yyline+", coluna "+yycolumn); }