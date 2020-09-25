package br.edu.fip.compiladores.analisadorlexico_minijava;

%%

%{
private void imprimir(String descricao, String lexema) {
    System.out.println(lexema + "\t- " + descricao);
}
%}

%class AnalisadorLexico
%type Object
%column
%line
%char

BRANCO = [ |\n|\t|\r|\f]
ID = [a-z|A-Z][a-z|A-Z|0-9|_]*
INTEIRO = 0|[1-9][0-9]*

%%

"boolean"                   {imprimir("Palavra reservada", yytext());}
"class"                     {imprimir("Palavra reservada", yytext());}
"extends"                   {imprimir("Palavra reservada", yytext());}
"public"                    {imprimir("Palavra reservada", yytext());}
"static"                    {imprimir("Palavra reservada", yytext());}
"void"                      {imprimir("Palavra reservada", yytext());}
"main"                      {imprimir("Palavra reservada", yytext());}
"String"                    {imprimir("Palavra reservada", yytext());}
"return"                    {imprimir("Palavra reservada", yytext());}
"int"                       {imprimir("Palavra reservada", yytext());}
"if"                        {imprimir("Palavra reservada", yytext());}
"else"                      {imprimir("Palavra reservada", yytext());}
"while"                     {imprimir("Palavra reservada", yytext());}
"System.out.println"        {imprimir("Palavra reservada", yytext());}
"length"                    {imprimir("Palavra reservada", yytext());}
"true"                      {imprimir("Palavra reservada", yytext());}
"false"                     {imprimir("Palavra reservada", yytext());}
"this"                      {imprimir("Palavra reservada", yytext());}
"new"                       {imprimir("Palavra reservada", yytext());}

{BRANCO}                    {imprimir("Espaço em branco", yytext());}
{ID}                        {imprimir("Identificador", yytext());}
{INTEIRO}                   {imprimir("Número Inteiro", yytext());}

"{"                         {imprimir("Delimitador", yytext());}
"}"                         {imprimir("Delimitador", yytext());}
"["                         {imprimir("Delimitador", yytext());}
"]"                         {imprimir("Delimitador", yytext());}
"("                         {imprimir("Delimitador", yytext());}
")"                         {imprimir("Delimitador", yytext());}
";"                         {imprimir("Delimitador", yytext());}
"."                         {imprimir("Delimitador", yytext());}
","                         {imprimir("Delimitador", yytext());}
"="                         {imprimir("Símbolo de atribuição", yytext());}
"<"                         {imprimir("Símbolo de comparação", yytext());}
"=="                        {imprimir("Símbolo de comparação", yytext());}
"!="                        {imprimir("Símbolo de comparação", yytext());}
"+"                         {imprimir("Operador de soma", yytext());}
"-"                         {imprimir("Operador de subtração", yytext());}
"*"                         {imprimir("Operador de multiplicação", yytext());}
"/"                         {imprimir("Operador de divisão", yytext());}
"&&"                        {imprimir("Símbolo de relação", yytext());}
"!"                         {imprimir("Símbolo de relação", yytext());}

. { throw new RuntimeException("Caractere invalido \"" +yytext() +
"\" na linha "+yyline+", coluna "+yycolumn); }